package br.com.rickicr_collab.WebSystemR.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rickicr_collab.WebSystemR.dto.auth.LoginRequestDTO;
import br.com.rickicr_collab.WebSystemR.dto.auth.LoginResponseDTO;
import br.com.rickicr_collab.WebSystemR.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.login(),
                loginRequestDTO.senha());
                Authentication authentication = authenticationManager.authenticate(authToken);
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String jwtToken = jwtService.gerarToken(userDetails);
                LoginResponseDTO loginResponse = new LoginResponseDTO(jwtToken);
                return ResponseEntity.ok(loginResponse);
    }

}
