package gong.example.account.authentication;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. request 에서 토큰을 뽑아내서 토큰으로 유저 정보를 확인
        // 2. 해당 유저 정보로 토큰의 만료 여부 등을 확인

        // 3. 위 과정중 에러가 발생할시 throw Exception

        // 4. 정상적으로 인증이 될경우 filterChain.doFilter 로 다음 필터로 넘기기

    }
}
