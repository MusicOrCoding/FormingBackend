package com.tave.forming.domain.joinInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tave.forming.domain.BaseTimeEntity;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class JoinInfo extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "join_info_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Teams team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime joinDate;

    @Builder
    public JoinInfo(Teams team, User user, LocalDateTime joinDate) {
        this.team = team;
        this.user = user;
        this.joinDate = joinDate;
    }

}
