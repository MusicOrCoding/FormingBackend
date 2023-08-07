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
//
    //답변옵션 엔티티와 연관관계 매핑
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Option> answerOptionList = new ArrayList<>();

    // 설문조사 PK
    private Long surveyId;

    //문항넘버(해당 설문조사 내 몇번째 문항인지)
    private Long questionNum;

    //문항 내용(질문명)
    private String title;

    //문항의 종류(객관식/ 주관식)
    private String type;

    //해당 문항의 답변 선택지(option) 개수
    private int optionCount;



    /*
    //==생성 메서드==//
    public static Question createQuestion(Long question_num, String title, String type, int option_count, AnswerOption... answerOptions) {
        Question question = new Question();
        question.question_num = question_num;
        question.title = title;
        question.type = type;
        question.option_count = option_count;


        for(Option Option: answerOptions) {
            question.addOption(answerOption);
        }

        return question;
    }

     */



    @Builder
    public Question(Survey survey, Long questionNum, String title, String type, int optionCount, Long surveyId, List<Option> answerOptionList) {
        this.survey = survey;
        this.questionNum = questionNum;
        this.title = title;
        this.type = type;
        this.optionCount = optionCount;
        this.surveyId = surveyId;
        this.answerOptionList = answerOptionList;
    }
}
