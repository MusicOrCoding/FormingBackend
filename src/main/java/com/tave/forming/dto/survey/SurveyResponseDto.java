package com.tave.forming.dto.survey;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tave.forming.domain.survey.Question;
import com.tave.forming.domain.survey.Survey;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class SurveyResponseDto {

    private Long id;
    //설문조사 제목
    private String title;

    //설문조사 설명
    private String content;

    //팀 설문조사 여부. 0이면 개인 설문조사, 1이면 팀 설문조사.
    private int isTeam;

    //마감 일자
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDate deadlineDate;

    //최대 참여 인원
    private int maxParticipants;

    //마감 여부. 0이면 false(마감x), 1이면 true(마감o)
    private int isOver;

    //리워드 포인트 가격
    private Long rewardPoint;

    //만드는 데 드는 포인트
    private Long costPoint;

    //설문조사 대상
    private String target;

    //설문조사 문항 리스트
    private List<Question> questionList;

    public SurveyResponseDto(Survey entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.isTeam = entity.getIsTeam();
        this.deadlineDate = entity.getDeadlineDate();
        this.isOver = entity.getIsOver();
        this.costPoint = entity.getCostPoint();
        this.rewardPoint = entity.getRewardPoint();
        this.target = entity.getTarget();
        this.questionList = entity.getQuestionList();
    }
}
