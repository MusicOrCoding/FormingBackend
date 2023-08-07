package com.tave.forming.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class SurveyDeleteRequestDto {
    private Long userId;
    @NotNull
    private Long surveyId;
}
