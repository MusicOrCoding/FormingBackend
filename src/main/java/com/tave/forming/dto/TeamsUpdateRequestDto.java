package com.tave.forming.dto;

import com.tave.forming.domain.teams.GroupType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamsUpdateRequestDto {
    private String name;
    private String password;
    private GroupType group_type;
    private Long point;


    @Builder
    public TeamsUpdateRequestDto(String name, String password, GroupType group_type, Long point) {
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
    }


}
