package com.tave.forming.controller;

import com.tave.forming.config.UserPrincipal;
import com.tave.forming.dto.BasicResponse;
import com.tave.forming.dto.SurveyDeleteRequestDto;
import com.tave.forming.dto.SurveySaveAllRequestDto;
import com.tave.forming.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @DeleteMapping("/survey/del")
    public ResponseEntity<BasicResponse> deleteSurvey(Authentication authentication, @RequestBody SurveyDeleteRequestDto surveyDeleteRequestDto){
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        surveyDeleteRequestDto.setUserId(userPrincipal.getUser().getId());

        boolean result = surveyService.removeSurvey(surveyDeleteRequestDto);

        BasicResponse deleteSurveyRes;

        if(result) {
             deleteSurveyRes = BasicResponse.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("설문 조사 삭제가 완료되었습니다.")
                    .build();

             return new ResponseEntity<>(deleteSurveyRes, deleteSurveyRes.getHttpStatus());
        }


        deleteSurveyRes = BasicResponse.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .httpStatus(HttpStatus.FORBIDDEN)
                .message("설문조사 삭제 권한이 존재하지 않습니다.")
                .build();

        return new ResponseEntity<>(deleteSurveyRes, deleteSurveyRes.getHttpStatus());
    }

}