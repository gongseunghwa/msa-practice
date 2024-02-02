package gong.example.account.common.utils;

import gong.example.account.entity.Client;
import gong.example.account.exception.PreventConstructorException;
import gong.example.account.repository.ClientRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class JwtUtils implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    private Key key;
    @Value("${jwt.key}")
    private String secret;
    public static final String JWT_HEADER_KEY = HttpHeaders.AUTHORIZATION;
    public static final String JWT_HEADER_TOKEN_HEAD_KEY = "Bearer";
    private final String CLIENT_ID = "client_id";
    private final String CLIENT_NM = "client_name";
    private final String CLIENT_ROLE = "client_role";

    private final int TOKEN_EXPIRE_TIME = 1000 * 60 * 60;
    public String generateToken(Client client) {
        return generateToken(client, TOKEN_EXPIRE_TIME);
    }

    public String generateToken(Client client, int expireTime) {
        HashMap<String, Object> claims = new HashMap<>();

        claims.put(CLIENT_ID, client.getUserId());
        claims.put(CLIENT_NM, client.getUserName());
        claims.put(CLIENT_ROLE, client.getRole().name());

        // 만료시간
        Date expirationDate = new Date(System.currentTimeMillis() + expireTime);
        return Jwts.builder().addClaims(claims).signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(expirationDate)
                .compact();
    }

    //0. HttpRequest를 받아서 암호화된 토큰만 반환하는 함수

    //1. HttpRequest 를 받아서 Authorization 에 관한 정보를 가져오는 함수

    //2. 문자열을 받아서 Baerer를 자르는 함수

}
