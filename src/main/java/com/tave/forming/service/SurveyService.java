package com.tave.forming.service;

import com.tave.forming.domain.user.User;
import com.tave.forming.domain.jpa.UserRepository;
import com.tave.forming.domain.survey.Question;
import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.jpa.SurveyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SurveyService {

    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;

    //설문조사 생성
    @Transactional
    public Long saveSurvey(Long user_id, String title, String content, int is_team, LocalDateTime deadline_date, Long max_participants, int is_over, Long reward_point, Long cost_point, String target, User user, Long team_id, Question... questions) {
        //엔티티 조회
        User user1 = userRepository.findById(user_id).orElseThrow(()-> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        //설문조사 생성
        Survey survey = Survey.createSurvey(title, content, is_team, deadline_date, max_participants, is_over, reward_point, cost_point, target, user,team_id,questions);

        //설문조사 저장
        surveyRepository.save(survey);

        return survey.getId();
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
        return surveyRepository.findById(surveyId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 설문조사 입니다."));
    }
}
