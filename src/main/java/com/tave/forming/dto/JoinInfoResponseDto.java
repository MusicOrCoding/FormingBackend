package com.tave.forming.dto;

import com.tave.forming.domain.joinInfo.JoinInfo;
import com.tave.forming.domain.teams.Teams;
import com.tave.forming.domain.user.User;
import lombok.Getter;

@Getter
public class JoinInfoResponseDto {

    private User user;
    private Teams team;

    public JoinInfoResponseDto(JoinInfo entity) {
        this.user = entity.getUser();
        this.team = entity.getTeam();
    }
}
