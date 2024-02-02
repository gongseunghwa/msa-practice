package gong.example.account.config;

import gong.example.account.authentication.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // springboot 3.1.x  이상부터 EnableGlobalMethodSecurity 가 해당 어노테이션으로 변경되었다.
@RequiredArgsConstructor
public class SecurityConfig {
    //기존에 WebSecurityAdapter 를 상속받아 작성하던 것이 변경되었다.

    private final JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    // 해당 함수 에서 접근 및 필터에 관련된 설정을 추가한다.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf((csrf) -> csrf.disable())
                .headers((header) -> header.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()))
                .addFilter((servletRequest, servletResponse, filterChain) -> {
                    filterChain.doFilter(servletRequest, servletResponse);
                })
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/api/v1/**").permitAll()
                                .anyRequest().permitAll()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
