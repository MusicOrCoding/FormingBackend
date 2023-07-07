package com.tave.forming.dto;

import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SurveySaveRequestDto {
    private User user;

    private Teams team;

    //private List<Question> questions = new ArrayList<>();

    private String title;

    private String content;

    private int is_team;

    private int question_count;

    private LocalDateTime deadline_date;

    private Long max_participants;

    private int is_over;

    private Long reward_point;

    private Long cost_point;

    private String target;





    //Question엔티티 dto들은 어떻게 처리할지..
    @Builder
    public SurveySaveRequestDto(User user, String title, String content, int is_team, int question_count, LocalDateTime deadline_date, Long max_participants, int is_over, Long reward_point, Long cost_point, String target, Teams team) {

        this.user = user;
        this.title = title;
        this.content = content;
        this.is_team = is_team;
        this.question_count = question_count;
        this.deadline_date = deadline_date;
        this.max_participants = max_participants;
        this.is_over = is_over;
        this.reward_point = reward_point;
        this.cost_point = cost_point;
        this.target = target;
        this.team = team;
    }

    public Survey toEntity() {
        return Survey.builder()
                .title(title)
                .content(content)
                .is_team(is_team)
                .question_count(question_count)
                .deadline_date(deadline_date)
                .max_participants(max_participants)
                .is_over(is_over)
                .reward_point(reward_point)
                .cost_point(cost_point)
                .target(target)
                .team(team)
                .build();
    }
}
