package com.tave.forming.dto;

import com.tave.forming.domain.survey.Question;
import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class SurveySaveRequestDto {
    private User user;

    private List<Question> questions = new ArrayList<>();

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

    //private Long user_id;

    private Long team_id;

    // ==연관관계 메서드 == //
//    public void addQuestion(Question question) {
//        questions.add(question);
//        question.setSurvey(this);
//    }

    //==비즈니스 로직==//
    public void addQuestion(int num) {
        this.question_count += num;
    }

    public void removeQuestion(int num) {
        this.question_count -= num;
    }



    //Question엔티티 dto들은 어떻게 처리할지..
    @Builder
    public SurveySaveRequestDto(User user, String title, String content, int is_team, int question_count, LocalDateTime deadline_date, Long max_participants, int is_over, Long reward_point, Long cost_point, String target, Long team_id) {

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
        this.team_id = team_id;
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
                .team_id(team_id)
                .build();
    }
}
