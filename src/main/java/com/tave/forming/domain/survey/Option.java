package com.tave.forming.domain.survey;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    private Long surveyId;

    private Long questionId;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Builder
    public Option(Long id, Long surveyId, Long questionId, String content, Question question){
        this.id = id;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.content = content;
        this.question = question;
    }


}
