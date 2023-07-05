package com.tave.forming.config;

import com.tave.forming.domain.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class UserPrincipal implements OAuth2User, UserDetails {
    private User user;
    private Map<String, Object> attributes;

    public UserPrincipal(User user) {
        this.user = user;
    }

    //OAuth 로그인 생성자
    public UserPrincipal(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    //OAuth2User 인터페이스 메서드
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    //해당 user 의 권한을 리턴(role)
    //SecurityFilterChain 에서 권한을 확인할 때 사용된다.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return String.valueOf(user.getRole());
            }
        });
        return collection;
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
