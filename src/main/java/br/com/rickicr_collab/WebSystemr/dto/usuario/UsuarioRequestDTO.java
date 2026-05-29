package br.com.rickicr_collab.WebSystemR.dto.usuario;

import br.com.rickicr_collab.WebSystemR.enums.Perfil;

public record UsuarioRequestDTO(
    String nomeCompleto,
    String login,
    String senha,
    String email,
    String telefone,
    Perfil perfil
) {

}
