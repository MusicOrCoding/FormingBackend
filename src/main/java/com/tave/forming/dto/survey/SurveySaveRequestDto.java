package com.tave.forming.dto.survey;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SurveySaveRequestDto {


    //설문조사 만든 팀id
    private Long teamId;

    //설문조사 만든 이용자 id
    private Long userId;

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
    private boolean isOver;

    //리워드 포인트 가격
    private Long rewardPoint;

    //만드는 데 드는 포인트
    private Long costPoint;

    //설문조사 대상
    private String target;


    public Survey toEntity(User user, Teams team) {
        return Survey.builder()
                .user(user)
                .team(team)
                .title(title)
                .content(content)
                .isTeam(isTeam)
                .deadlineDate(deadlineDate)
                .isOver(isOver)
                .maxParticipants(maxParticipants)
                .rewardPoint(rewardPoint)
                .costPoint(costPoint)
                .target(target)
                .build();
    }

}
