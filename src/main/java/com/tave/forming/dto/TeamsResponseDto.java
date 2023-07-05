package com.tave.forming.dto;

import com.tave.forming.domain.teams.GroupType;
import com.tave.forming.domain.teams.Teams;
import lombok.Getter;

@Getter
public class TeamsResponseDto {
    private Long id;
    private String name;
    private GroupType group_type;
    private String password;
    private Long point;

    public TeamsResponseDto(Teams entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.group_type = entity.getGroup_type();
        this.password = entity.getPassword();
        this.point = entity.getPoint();
    }
}
