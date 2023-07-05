package com.tave.forming.config;

import com.tave.forming.config.auth.CustomOAuth2UserService;
import com.tave.forming.config.auth.OAuth2AuthorizationRequestBasedOnCookieRepository;
import com.tave.forming.config.auth.OAuth2SuccessHandler;
import com.tave.forming.config.jwt.TokenProvider;
import com.tave.forming.domain.jpa.RefreshTokenRepository;
import com.tave.forming.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final Userservice userService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //토큰 방식으로 인증을 하기 때문에 기존에 사용하던 폼로그인, 세션 비활성화
        http.
                cors()
                .and()
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //헤더를 확인할 커스텀 필터 추가
        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


        //요청에 대한 권한 설정
        http.authorizeRequests()
                .antMatchers("/main", "/token").permitAll()
                .antMatchers("/admin/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated();

        //oauth2Login
        http
                .oauth2Login()
                .loginPage("/login")
                .authorizationEndpoint()
                //Authorization 요청과 관련된 상태 저장
                .authorizationRequestRepository(oAuth2AuthorizationRequestBasedOnCookieRepository())
                .and()
                .successHandler(oAuth2SuccessHandler())
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

        http.logout()
                .logoutSuccessUrl("/login");

        return http.build();
    }

    @Bean
    public OAuth2SuccessHandler oAuth2SuccessHandler() {
        return new OAuth2SuccessHandler(tokenProvider,
                refreshTokenRepository,
                oAuth2AuthorizationRequestBasedOnCookieRepository(),
                userService);
    }

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter(tokenProvider);
    }

    @Bean
    public OAuth2AuthorizationRequestBasedOnCookieRepository oAuth2AuthorizationRequestBasedOnCookieRepository(){
        return new OAuth2AuthorizationRequestBasedOnCookieRepository();
    }
}
