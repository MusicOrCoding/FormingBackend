package com.tave.forming.service;

import com.tave.forming.domain.jpa.*;
import com.tave.forming.domain.survey.Option;
import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import com.tave.forming.dto.survey.SurveyResponseDto;
import com.tave.forming.dto.survey.SurveySaveRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SurveyService {

    private final UserRepository userRepository;
    private final TeamsRepository teamsRepository;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final Option answerOption;
    private final JoinInfoRepository joinInfoRepository;

    //설문조사 테이블에 정보 생성
    @Transactional
    public Long saveSurvey(Long userId, SurveySaveRequestDto surveySaveRequestDto) {
        /**
         * 1. 팀 프로젝트 인지 아닌지 확인 -> 팀프로젝트인 경우에는 팀에 가입해 있는 경우만 생성 가능
         */

        Long surveyId;
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        Teams team = teamsRepository.findById(surveySaveRequestDto.getTeamId()).orElseThrow(() -> new IllegalArgumentException("해당 팀이 존재하지 않습니다."));

        //팀 설문조사일 때
        if (surveySaveRequestDto.getIsTeam() == 1) {
            //팀 여부 조회 로직 추가
            //팀에 가입된 사람이 아닐 경우 팀 설문조사 생성 불가
            if (joinInfoRepository.findByUserAndTeam(user, team) == null) {
                return 0L;
            } else {
              // 팀에 가입된 사람일 경우 팀 설문조사 생성
                surveyId = surveyRepository.save(surveySaveRequestDto.toEntity(user, team)).getId();
            }

        } else {
            //개인 설문 조사 일 때
            surveyId = surveyRepository.save(surveySaveRequestDto.toEntity(user, team)).getId();
        }

        return surveyId;
    }

    //특정 팀이 생성한 설문조사 조회
    public List<SurveyResponseDto> findSurveysByTeam(Long teamId) {
        Teams team = teamsRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("해당 팀이 존재하지 않습니다."));
        return surveyRepository.findByTeam(team).stream().map(SurveyResponseDto::new).collect(Collectors.toList());
    }




    //설문조사 조회
    public List<SurveyResponseDto> findSurveys() {
        return surveyRepository.findAll().stream().map(SurveyResponseDto::new).collect(Collectors.toList());
    }

    //유저별 생성한 설문조사 조회
    public List<SurveyResponseDto> findSurveysByUser(Long userId) {
        return surveyRepository.findByUserId(userId).stream().map(SurveyResponseDto::new).collect(Collectors.toList());
    }

    //개별 조회
    public SurveyResponseDto findOne(Long surveyId) {
        Survey s = surveyRepository.findById(surveyId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 설문조사 입니다."));
        SurveyResponseDto surveyResponseDto = new SurveyResponseDto(s);
        return surveyResponseDto;
    }
}