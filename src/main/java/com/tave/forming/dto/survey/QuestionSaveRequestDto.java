package com.tave.forming.dto.survey;

import com.tave.forming.domain.survey.Question;
import com.tave.forming.domain.survey.Survey;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionSaveRequestDto {  //설문조사 질문 저장

    private Long surveyId;
    private Long questionNum;
    private String title;
    private String type;
    private int optionCount;

    @Builder
    public QuestionSaveRequestDto(Long surveyId, Long questionNum, String title, String type, int optionCount) {
        this.surveyId = surveyId;
        this.questionNum = questionNum;
        this.title = title;
        this.type = type;
        this.optionCount = optionCount;
    }

    public Question toEntity(Survey survey) {
        return Question.builder()
                .survey(survey)
                .questionNum(questionNum)
                .title(title)
                .type(type)
                .optionCount(optionCount)
                .build();
    }
}
