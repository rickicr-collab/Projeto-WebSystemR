package br.com.rickicr_collab.WebSystemR.dto.usuario;

import br.com.rickicr_collab.WebSystemR.enums.Perfil;

public record UsuarioResponseDTO(
    Long id,
    String nomeCompleto,
    String login,
    String email,
    String telefone,
    Perfil perfil
) {

}
