package com.tave.forming.dto;

import com.tave.forming.domain.teams.GroupType;
import com.tave.forming.domain.teams.Teams;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//View를 위한 클래스, Controller에서 사용
@Getter
@NoArgsConstructor
public class TeamsSaveRequestDto {
    private String name;
    private GroupType group_type;
    private String password;
    private Long point;
    @Builder
    public TeamsSaveRequestDto(String name, GroupType group_type, String password, Long point){
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
    }

    public Teams toEntity() {
        return Teams.builder()
                .name(name)
                .group_type(GroupType.valueOf(String.valueOf(group_type)))
                .password(password)
                .point(point)
                .build();
    }
}
