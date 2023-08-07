package com.tave.forming.dto.survey;

import com.tave.forming.domain.survey.Option;
import com.tave.forming.domain.survey.Question;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class SurveySaveAllRequestDto {

    private User user;

    private Teams team;

    private List<Question> questions = new ArrayList<>();

    private String title;

    private String content;

    private int is_team;

    private LocalDate deadline_date;

    private int max_participants;

    private boolean is_over;

    private Long reward_point;

    private Long cost_point;

    private String target;

    private List<Option> answerOptions;

    @Builder
    public SurveySaveAllRequestDto(User user, String title, String content, int is_team, LocalDate deadline_date, int max_participants, boolean is_over, Long reward_point, Long cost_point, String target, Teams team, List<Question> questions, List<Option> Options) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.is_team = is_team;
        this.deadline_date = deadline_date;
        this.max_participants = max_participants;
        this.is_over = is_over;
        this.reward_point = reward_point;
        this.cost_point = cost_point;
        this.target = target;
        this.team = team;
        this.answerOptions = Options;
        this.questions = questions;
    }



}
