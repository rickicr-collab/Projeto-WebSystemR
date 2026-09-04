package br.com.rickicr_collab.WebSystemR.config;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Jwts;

@Configuration
public class JwtConfig {

    private final long expirationTime;

    public JwtConfig(@Value("${jwt.expirationTime}")Long expirationTime){
        this.expirationTime = expirationTime;
    }

    @Bean
    public SecretKey secretKey(){
        return Jwts.SIG.HS256.key().build();

    }

}
