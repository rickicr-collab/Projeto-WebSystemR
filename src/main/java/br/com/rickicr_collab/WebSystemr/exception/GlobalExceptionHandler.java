package br.com.rickicr_collab.WebSystemR.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.rickicr_collab.WebSystemR.dto.error.ErroResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Tratamento para exceção de usuário não encontrado
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponseDTO> tratarUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(criarErroResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    // Tratamento para exceção de email já cadastrado
    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ErroResponseDTO> tratarEmailJaCadastrado(EmailJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(criarErroResponse(HttpStatus.CONFLICT, ex.getMessage()));

    }

    // Tratamento para exceção de login já cadastrado
    @ExceptionHandler(LoginJaCadastradoException.class)
    public ResponseEntity<ErroResponseDTO> tratarLoginJaCadastrado(LoginJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(criarErroResponse(HttpStatus.CONFLICT, ex.getMessage()));
    }


    private ErroResponseDTO criarErroResponse(HttpStatus status, String message){
        return new ErroResponseDTO(
            LocalDateTime.now(),
            status.value(),
            status.getReasonPhrase(),
            message
        );
    }
}
