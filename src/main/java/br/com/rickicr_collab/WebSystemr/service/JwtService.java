package br.com.rickicr_collab.WebSystemR.service;

import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.rickicr_collab.WebSystemR.entity.Usuario;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;


@Service
public class JwtService {

    private final SecretKey secretKey;
    private final Long expirationTime;

    public JwtService(SecretKey secretKey,@Value("${jwt.expirationTime}") Long expirationTime){
        this.secretKey = secretKey;
        this.expirationTime = expirationTime;
    }


    public String gerarToken(UserDetails userDetails){
        Usuario usuario = (Usuario) userDetails;
        return Jwts.builder()
        .subject(userDetails.getUsername())
        .claim("id", usuario.getId())
        .claim("Perfil", usuario.getPerfil().name())
        .expiration(Date.from(Instant.now().plusMillis(expirationTime)))
        .signWith(secretKey)
        .compact();
        
    }

    public String extrairUsername(String token){
        return Jwts.parser()
                   .verifyWith(secretKey)
                   .build()
                   .parseSignedClaims(token)
                   .getPayload()
                   .getSubject();
    }

    
    public String extrairPerfil(String token){
        return Jwts.parser()
                   .verifyWith(secretKey)
                   .build()
                   .parseSignedClaims(token)
                   .getPayload()
                   .get("Perfil", String.class);
    }

    public boolean validarToken(String token){
        try{
            Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);
            return true;
        }catch(JwtException | IllegalArgumentException e){
            return false;
        }
    }
}
