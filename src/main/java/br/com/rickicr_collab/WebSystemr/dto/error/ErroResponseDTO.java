package br.com.rickicr_collab.WebSystemR.dto.error;

import java.time.LocalDateTime;

public record ErroResponseDTO(

     LocalDateTime timestamp,
     int status,
     String error,
     String message
) {}
