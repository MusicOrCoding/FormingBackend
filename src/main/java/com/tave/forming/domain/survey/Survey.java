package com.tave.forming.domain.survey;

import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import com.tave.forming.exception.*;
import com.tave.forming.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Survey extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long id;

    //설문조사 만든 사용자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //설문조사 만든 팀
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Teams team;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @Column(name = "title")
    private String title;

    //설문조사 설명
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    //팀 설문조사 여부. 0이면 개인 설문조사, 1이면 팀 설문조사.
    private int is_team;

    //문항 개수
    private int question_count = 0;

    //마감 일자
    private LocalDateTime deadline_date;

    //최대 참여 인원
    private Long max_participants;

    //마감 여부. 0이면 false(마감x), 1이면 true(마감o)
    private int is_over;

    //리워드 포인트 가격
    private Long reward_point;

    //만드는 데 드는 포인트
    private Long cost_point;

    //설문조사 대상
    private String target;

    //작성한 사용자 id
   // private Long user_id;

    //작성한 팀 id
    //private Long team_id;

    // ==연관관계 메서드 == //
    public void addQuestion(Question question) {
        questions.add(question);
        question.setSurvey(this);
    }

    public void setUser(User user) {
        this.user = user;
        this.user.getSurveys().add(this);
    }

    public void setTeam (Teams team) {
        this.team = team;
        this.team.getSurveys().add(this);
    }

    //==비즈니스 로직==//
    public void addQuestion(int num) {
        this.question_count += num;
    }

    public void removeQuestion(int num) {
        int count = this.question_count - num;
        if (count < 0) {
            throw new NotEnoughQuestionCountException("need more question");
        }
        this.question_count = count;
    }


    //==생성 메서드==//
    public static Survey createSurvey(String title, String content, int is_team, LocalDateTime deadline_date, Long max_participants, int is_over, Long reward_point, Long cost_point, String target, User user,Long team_id, Question... questions) {
        Survey survey = new Survey();
        survey.title = title;
        survey.content = content;
        survey.is_team = is_team;
        //survey.question_count = question_count;
        survey.deadline_date = deadline_date;
        survey.max_participants = max_participants;
        survey.is_over = is_over;
        survey.reward_point = reward_point;
        survey.cost_point = cost_point;
        survey.target = target;
        survey.setUser(user);
        for (Question question : questions) {
            survey.addQuestion(question);
            survey.addQuestion(1);
        }
        //survey.team_id = team_id;
        return survey;
    }

    @Builder
    public Survey( String title, String content, int is_team, int question_count, LocalDateTime deadline_date, Long max_participants, int is_over, Long reward_point, Long cost_point, String target, Teams team, User user) {

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
}
