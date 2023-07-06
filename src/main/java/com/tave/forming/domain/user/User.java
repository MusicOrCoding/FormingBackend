package com.tave.forming.domain.user;

import com.tave.forming.domain.BaseTimeEntity;
import com.tave.forming.domain.survey.Survey;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Survey> surveys = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String provider; //어떤 OAuth 인지
    private String providerId; // 해당 OAuth 의 key(id)

    @Builder
    public User(String name, String email, Role role, String provider, String providerId){
        this.name = name;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }


    public String getRoleKey() {
        return this.role.getKey();
    }

    //public void updateRefreshToken(String reI)

}
