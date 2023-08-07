package com.tave.forming.domain.teams;

import com.tave.forming.domain.BaseTimeEntity;
import com.tave.forming.domain.joinInfo.JoinInfo;
import com.tave.forming.domain.survey.Survey;
import com.tave.forming.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class Teams extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="team_id")
    private Long id;


    //팀 생성한 사용자와 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User ownerUser;

    @OneToMany(mappedBy = "team")
    private List<Survey> surveys = new ArrayList<>();


    @OneToMany(mappedBy = "team")
    private List<JoinInfo> joinInfoList = new ArrayList<>();



    @Column(nullable = false, name = "team_name", unique = true)
    private String name;

    //@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "group_type")
    private GroupType group_type;

    @Column(name = "password")
    private String password;

    @Column(name = "point")
    private Long point;



    @Builder
    public Teams(String name, GroupType group_type, String password, Long point, User ownerUser){
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
        this.ownerUser = ownerUser;
    }

    public void update(String name, String password, GroupType group_type, Long point) {
        this.name = name;
        this.group_type = group_type;
        this.password = password;
        this.point = point;
    }
}
