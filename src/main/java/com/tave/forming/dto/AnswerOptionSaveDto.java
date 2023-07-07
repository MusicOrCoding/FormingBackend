package com.tave.forming.dto;

import com.tave.forming.domain.survey.AnswerOption;
import com.tave.forming.domain.survey.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerOptionSaveDto {

    private Question question;
    private String content;

    @Builder
    public AnswerOptionSaveDto(Question question, String content) {
        this.question = question;
        this.content = content;
    }

    public AnswerOption toEntity() {
        return AnswerOption.builder()
                .question(question)
                .content(content)
                .build();
    }
}
