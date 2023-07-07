package com.tave.forming.dto;

import com.tave.forming.domain.survey.Question;
import com.tave.forming.domain.survey.Survey;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionSaveRequestDto {

    private Survey survey;
    private Long questionNum;
    private String title;
    private String type;
    private int optionCount;

    @Builder
    public QuestionSaveRequestDto(Survey survey, Long questionNum, String title, String type, int optionCount) {
        this.survey = survey;
        this.questionNum = questionNum;
        this.title = title;
        this.type = type;
        this.optionCount = optionCount;
    }

    public Question toEntity() {
        return Question.builder().
                survey(survey)
                .question_num(questionNum)
                .title(title)
                .type(type)
                .option_count(optionCount)
                .build();
    }
}
