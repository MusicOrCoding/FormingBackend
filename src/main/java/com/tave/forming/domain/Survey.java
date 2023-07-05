package com.tave.forming.domain;

import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@RequiredArgsConstructor
public class Survey extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long survey_id;

    private String title;

    private String content;

    private boolean is_team;

    private int question_count;

    private LocalDate deadline_date;

    private int max_participant;

    private boolean is_over;

    private Long reward_point;

    @OneToOne
    @JoinColumn(name ="user_id")
    private User user;


    private Long team_id;

    private Long cost_point;

    private String target;

    /*
    @Builder
    public Survey(Long survey_id, String title, String content, boolean is_team, int question_count,
                  LocalDate deadline_date, int max_participant, boolean is_over, Long reward_point,  )


     */


}
