package com.tave.forming.domain.survey;

import com.tave.forming.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Question extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    // 설문조사 엔티티와 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    //답변옵션 엔티티와 연관관계 매핑
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<AnswerOption> answerOptions = new ArrayList<>();

    //문항넘버(해당 설문조사 내 몇번째 문항인지)
    private Long question_num;

    //문항 내용(질문명)
    private String title;

    //문항의 종류(객관식/ 주관식)
    private String type;

    //해당 문항의 답변 선택지(option) 개수
    private int option_count;

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    //== 연관관계 메서드 ==//
    public void addOption(AnswerOption option) {
        answerOptions.add(option);
        option.setQuestion(this);
    }

    //==생성 메서드==//
    public static Question createQuestion(Long question_num, String title, String type, int option_count, AnswerOption... answer_options) {
        Question question = new Question();
        question.question_num = question_num;
        question.title = title;
        question.type = type;
        question.option_count = option_count;


        for(AnswerOption answerOption: answerOptions) {
            question.addOption(answerOption);
        }

        return question;
    }

    //==비즈니스 로직==//
    public void addOptionNum(int num) {
        this.option_count += num;
    }

    public void cancelOption(int num) {
        this.option_count -= 1;
    }


    @Builder
    public Question(Long question_num, String title, String type, int option_count) {
        this.question_num = question_num;
        this.title = title;
        this.type = type;
        this.option_count = option_count;
    }
}
