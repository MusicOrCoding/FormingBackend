package com.tave.forming.service;

import com.tave.forming.domain.jpa.JoinInfoRepository;
import com.tave.forming.domain.jpa.QuestionRepository;
import com.tave.forming.domain.jpa.SurveyRepository;
import com.tave.forming.domain.jpa.UserRepository;
import com.tave.forming.domain.survey.Option;
import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.user.User;
import com.tave.forming.dto.SurveyDeleteRequestDto;
import com.tave.forming.dto.SurveyDetailDto;
import com.tave.forming.dto.SurveySaveAllRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SurveyService {

    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final Option answerOption;
    private final JoinInfoRepository joinInfoRepository;


    //설문조사 테이블에 정보 생성
    @Transactional
    public Long saveSurvey(Long user_id, SurveySaveAllRequestDto surveySaveAllRequestDto) {
        /**
         * 1. 팀 프로젝트 인지 아닌지 확인 -> 팀프로젝트인 경우에는 팀에 가입해 있는 경우만 생성 가능
         */

        Long surveyId;

        SurveyDetailDto surveyDetailDto = SurveyDetailDto.builder()
                .title(surveySaveAllRequestDto.getTitle())
                .content(surveySaveAllRequestDto.getContent())
                .is_team(surveySaveAllRequestDto.getIs_team())
                .max_participants(surveySaveAllRequestDto.getMax_participants())
                .deadline_date(surveySaveAllRequestDto.getDeadline_date())
                .cost_point(surveySaveAllRequestDto.getCost_point())
                .reward_point(surveySaveAllRequestDto.getReward_point())
                .target(surveySaveAllRequestDto.getTarget())
                .build();

        if (surveySaveAllRequestDto.getIs_team() == 1) {
            //팀 여부 조회 로직 추가
            //팀에 가입된 사람이 아닐 경우 팀 설문조사 생성 불가
            if (joinInfoRepository.findByUserId(user_id) == null) {
                return 0L;
            } else {
                // 팀에 가입된 사람일 경우 팀 설문조사 생성
                surveyId = surveyRepository.save(surveyDetailDto.toEntity()).getId();
            }

        } else {
            //개인 설문 조사 일 때
            surveyId = surveyRepository.save(surveyDetailDto.toEntity()).getId();
        }


        return surveyId;
    }

    //설문조사 조회
    public List<Survey> findSurveys() {
        return surveyRepository.findAll();
    }

    //유저별 생성한 설문조사 조회
    public List<Survey> findSurveysByUser(Long user_id) {
        return surveyRepository.findByUserId(user_id);
    }

    //개별 조회
    public Survey findOne(Long surveyId) {
        return surveyRepository.findById(surveyId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 설문조사 입니다."));
    }


    /* 설문조사 삭제 */
    @Transactional
    public boolean removeSurvey(SurveyDeleteRequestDto surveyDeleteRequestDto) {
        Long userId = surveyDeleteRequestDto.getUserId();
        Survey survey = surveyRepository.findById(surveyDeleteRequestDto.getSurveyId()).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 설문 입니다."));
        if (!userId.equals(survey.getUser().getId())) {
            /* 설문을 만들지 않는 사람이 삭제를 시도하면 삭제 불가*/
            return false;
        }
        surveyRepository.deleteSurveyById(surveyDeleteRequestDto.getSurveyId());
        return true;
    }

    /* 설문 조사 수정 */


}