package com.example.oAuth2Demo.service;

import com.example.oAuth2Demo.model.User;
import com.example.oAuth2Demo.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class JwtService {

    @Autowired
    UserRepository userRepo;

    /**
    TODO: 该密码用于加密和解密JWT(JSON Web Token)，如果想废除已发放的JWT，修改次密码即可，
     该密码不应以这种形式保存在源代码中，需要找一下该密码合适的保存方式，例如：可以保存在数据库中。
     */
    private final String SECRET_KEY = "thisIsAnImportantSecretForGeneratingJWT1";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Integer extractUserId(String token) {
        final Claims claims = extractAllClaims(token);
        return (Integer) claims.get("userId");
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        Optional<User> user = userRepo.findById(userDetails.getUsername());
        assert user.isPresent();
        claims.put("userId", user.get().getId());
        return createToken(claims, userDetails.getUsername());
    }

    /**
     TODO: 对于移动端用户来说，需要允许长时间不使用应用下次使用也不需要登录，所以发放token的逻辑需要修改，
      需要和前端交流，是否能够获取设备的ID或者设备名称，如果可以则在claims中加入该信息，并修改validateToken函数
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    /**
     TODO: 如果是带有设备名称的token，检验token过期的逻辑不执行
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}