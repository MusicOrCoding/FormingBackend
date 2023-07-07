package com.tave.forming.dto;

import com.tave.forming.domain.survey.Answer;
import com.tave.forming.domain.survey.AnswerOption;
import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerSaveRequestDto {

    private User user;
    private AnswerOption answerOption;
    private String content;

    @Builder
    public AnswerSaveRequestDto(User user, AnswerOption answerOption, String content) {
        this.user = user;
        this.answerOption = answerOption;
        this.content = content;
    }

    public Answer toEntity() {
        return Answer.builder()
                .user(user)
                .answerOption(answerOption)
                .content(content)
                .build();
    }

}
