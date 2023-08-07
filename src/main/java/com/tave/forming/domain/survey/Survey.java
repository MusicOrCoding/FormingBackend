package com.tave.forming.domain.survey;

import com.tave.forming.domain.BaseTimeEntity;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
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
    private List<Question> questionList = new ArrayList<>();

    @Column(name = "title")
    private String title;

    //설문조사 설명
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    //팀 설문조사 여부. 0이면 개인 설문조사, 1이면 팀 설문조사.
    private int isTeam;

    //마감 일자
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

    //작성한 사용자 id
    private Long userId;

    //작성한 팀 id
    private Long teamId;


    @Builder
    public Survey(User user, Teams team, String title, String content, int isTeam, LocalDate deadlineDate, int maxParticipants, int isOver, Long rewardPoint, Long costPoint, String target, Long teamId, Long userId, List<Question> questionList) {
        this.user = user;
        this.team = team;
        this.title = title;
        this.content = content;
        this.isTeam = isTeam;
        this.deadlineDate = deadlineDate;
        this.maxParticipants = maxParticipants;
        this.isOver = isOver;
        this.rewardPoint = rewardPoint;
        this.costPoint = costPoint;
        this.target = target;
        this.teamId = teamId;
        this.userId = userId;
        this.questionList = questionList;
    }
}
