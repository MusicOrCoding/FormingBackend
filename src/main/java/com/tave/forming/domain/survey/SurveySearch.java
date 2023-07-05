package com.tave.forming.domain.survey;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SurveySearch {
    private String surveyTitle; //설문조사 이름
    private int is_over; //마감여부
}
