package com.tave.forming.domain.survey;

import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import com.tave.forming.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

    //마감 일자
    private LocalDate deadline_date;

    //최대 참여 인원
    private int max_participants;

    //마감 여부. 0이면 false(마감x), 1이면 true(마감o)
    private boolean is_over;

    //리워드 포인트 가격
    private Long reward_point;

    //만드는 데 드는 포인트
    private Long cost_point;

    //설문조사 대상
    private String target;

    //작성한 사용자 id
    //private Long user_id;

    //작성한 팀 id
    //private Long team_id;


    @Builder
    public Survey(String title, String content, int is_team, LocalDate deadline_date, int max_participants, boolean is_over, Long reward_point, Long cost_point, String target) {
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
}
