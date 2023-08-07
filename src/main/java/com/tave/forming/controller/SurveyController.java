package com.tave.forming.controller;

import com.tave.forming.config.UserPrincipal;
import com.tave.forming.dto.BasicResponse;
import com.tave.forming.dto.survey.SurveyResponseDto;
import com.tave.forming.dto.survey.SurveySaveRequestDto;
import com.tave.forming.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping("/survey/new")
    public ResponseEntity<BasicResponse> createSurvey(Authentication authentication, @RequestBody SurveySaveRequestDto dto){
        /**
         * authentication 객체 활용하여 user 정보 얻어오기
         */
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        BasicResponse surveyResponse = BasicResponse.builder()
                .code(HttpStatus.CREATED.value())
                .httpStatus(HttpStatus.CREATED)
                .message("설문 조사가 생성되었습니다.")
                .build();

        Long userId = userPrincipal.getUser().getId();

        surveyService.saveSurvey(userId, dto);

        return new ResponseEntity<>(surveyResponse, surveyResponse.getHttpStatus());

    }

    @GetMapping("/survey/all")
    public List<SurveyResponseDto> findAll() {
        return surveyService.findSurveys();
    }

    //팀별 설문조사 조회
    @GetMapping("/survey/{teamId}")
    public List<SurveyResponseDto> findByTeam(@PathVariable Long teamId) {
        return surveyService.findSurveysByTeam(teamId);
    }

    // 사용자의 자신이 생성한 설문조사 조회
    @GetMapping("/survey/byuser")
    public List<SurveyResponseDto> findByUser(Authentication auth) {

        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
        Long userId= userPrincipal.getUser().getId();
        return surveyService.findSurveysByUser(userId);
    }
}