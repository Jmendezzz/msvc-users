package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.token.TokenConstant;
import com.emazon.msvc.users.msvcusers.infrastructure.utils.constants.JwtTokenConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
@Component
public class JwtTokenServiceAdapter implements TokenService {
  @Value("${security.jwt.key}")
  private String key;

  @Value("${security.jwt.issuer}")
  private String issuer;
  @Override
  public String generateToken(String username, Long userId, Role role) {
    Algorithm algorithm = Algorithm.HMAC256(key);

    return JWT.create()
            .withIssuer(issuer)
            .withSubject(username)
            .withClaim(JwtTokenConstant.USER_ID_CLAIM, userId)
            .withClaim(JwtTokenConstant.USER_ROLE_CLAIM, role.getName())
            .withIssuedAt(new Date(System.currentTimeMillis()))
            .withExpiresAt(new Date(System.currentTimeMillis() + TokenConstant.TOKEN_EXPIRATION_TIME_IN_MS))
            .withJWTId(UUID.randomUUID().toString())
            .sign(algorithm);
  }

  @Override
  public boolean validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(key);
    try{
      JWT.require(algorithm)
              .withIssuer(issuer)
              .build()
              .verify(token);
    }catch (Exception e){
      return false;
    }

    return true;

  }

  @Override
  public String getUsernameFromToken(String token) {
    return JWT.decode(token).getSubject();
  }

  @Override
  public String getRoleFromToken(String token) {
    return JWT.decode(token).getClaim(JwtTokenConstant.USER_ROLE_CLAIM).asString();
  }
}
