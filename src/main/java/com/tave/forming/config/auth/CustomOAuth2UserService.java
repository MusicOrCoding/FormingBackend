package com.tave.forming.config.auth;

import com.tave.forming.config.UserPrincipal;
import com.tave.forming.config.auth.dto.GoogleUserInfo;
import com.tave.forming.config.auth.dto.OAuth2UserInfo;
import com.tave.forming.domain.user.Role;
import com.tave.forming.domain.user.User;
import com.tave.forming.domain.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        //OAuth 로그인 회원가입
        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2UserInfo oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());

        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String name = oAuth2UserInfo.getName();
        String email = oAuth2UserInfo.getEmail();
        Role role = Role.USER;

        User user = userRepository.findByEmail(email);

        //해당 서비스를 처음 이용하는 경우
        if(user == null){
            user = User.builder()
                    .name(name)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(user);
        }

        return new UserPrincipal(user, oAuth2User.getAttributes());
    }

}
