package com.tave.forming.dto;

import com.tave.forming.domain.joinInfo.JoinInfo;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinSaveRequestDto {

    private Teams team;
    private User user;

    @Builder
    public JoinSaveRequestDto(Teams team, User user) {
        this.team = team;
        this.user = user;
    }

    public JoinInfo toEntity() {
        return JoinInfo.builder().
                team(team)
                .user(user)
                .build();
    }

}
