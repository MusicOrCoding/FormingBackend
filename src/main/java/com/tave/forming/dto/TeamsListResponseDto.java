package com.tave.forming.dto;

import com.tave.forming.domain.teams.GroupType;
import com.tave.forming.domain.teams.Teams;
import lombok.Getter;

@Getter
public class TeamsListResponseDto {
    private Long id;
    private String name;
    private GroupType groupType;

    public TeamsListResponseDto(Teams entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.groupType = entity.getGroup_type();
    }

}
