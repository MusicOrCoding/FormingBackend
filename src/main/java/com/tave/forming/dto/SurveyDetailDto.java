package com.tave.forming.dto;

import com.tave.forming.domain.survey.Survey;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@RequiredArgsConstructor
public class SurveyDetailDto {
    private String title;
    private String content;
    private int is_team;
    private LocalDate deadline_date;
    private int max_participants;
    private boolean is_over;
    private Long reward_point;
    private Long cost_point;
    private String target;

    @Builder
    public SurveyDetailDto(String title, String content, int is_team, LocalDate deadline_date, int max_participants,
                           boolean is_over, Long reward_point, Long cost_point, String target){
        this.title = title;
        this.content = content;
        this.is_team = is_team;
        this.deadline_date = deadline_date;
        this.max_participants = max_participants;
        this.is_over = is_over;
        this.reward_point = reward_point;
        this.cost_point = cost_point;
        this.target = target;
    }

    public Survey toEntity(){
        return Survey.builder()
                .title(title)
                .content(content)
                .is_team(is_team)
                .is_over(is_over)
                .deadline_date(deadline_date)
                .max_participants(max_participants)
                .reward_point(reward_point)
                .cost_point(cost_point)
                .target(target)
                .build();
    }



}
