package com.tave.forming.domain.survey;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    private Long survey_id;

    private Long question_id;

    private String content;

    @Builder
    public Option(Long id, Long survey_id, Long question_id, String content){
        this.id = id;
        this.survey_id = survey_id;
        this.question_id = question_id;
        this.content = content;
    }


}
