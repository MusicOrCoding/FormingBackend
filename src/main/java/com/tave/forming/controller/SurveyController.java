package com.tave.forming.controller;

import com.tave.forming.config.UserPrincipal;
import com.tave.forming.domain.user.User;
import com.tave.forming.dto.BasicResponse;
import com.tave.forming.dto.SurveySaveAllRequestDto;
import com.tave.forming.dto.SurveySaveRequestDto;
import com.tave.forming.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping("/survey/new")
    public ResponseEntity<BasicResponse> createSurvey(Authentication authentication, @RequestBody SurveySaveAllRequestDto surveySaveAllRequestDto){
        /**
         * authentication 객체 활용하여 user 정보 얻어오기
         */

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        BasicResponse surveyResponse = BasicResponse.builder()
                .code(HttpStatus.CREATED.value())
                .httpStatus(HttpStatus.CREATED)
                .message("설문 조사가 생성돠었습니다.")
                .build();

        Long userId = userPrincipal.getUser().getId();

        surveyService.saveSurvey(userId,surveySaveAllRequestDto);

        return new ResponseEntity<>(surveyResponse, surveyResponse.getHttpStatus());


    }

}