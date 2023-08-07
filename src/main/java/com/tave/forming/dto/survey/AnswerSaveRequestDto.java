package com.tave.forming.dto.survey;

import com.tave.forming.domain.survey.Answer;
import com.tave.forming.domain.survey.Option;
import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerSaveRequestDto { //사용자의 답변 저장

    private User user;
    private Option answerOption;
    private String content;

    @Builder
    public AnswerSaveRequestDto(User user, Option answerOption, String content) {
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
