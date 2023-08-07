package com.tave.forming.dto.survey;

import com.tave.forming.domain.survey.Option;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerOptionSaveDto {  //문항 옵션 저장


    private Long questionId;
    private String content;

    @Builder
    public AnswerOptionSaveDto(Long questionId, String content) {
        this.questionId = questionId;
        this.content = content;
    }

    public Option toEntity(Long questionId, String content) {
        return Option.builder()
                .questionId(questionId)
                .content(content)
                .build();
    }
}
