package com.tave.forming.domain.survey;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class AnswerOption{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_option_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    //옵션 내용
    private String content;


    public void setQuestion(Question question) {
        this.question = question;
    }

    //==생성메서드==//
    public static AnswerOption createAnswerOption(String content) {
        AnswerOption answerOption = new AnswerOption();
        answerOption.content = content;

        return answerOption;

    }

    @Builder
    public AnswerOption(Question question, String content) {
        this.question = question;
        this.content = content;
    }


}
