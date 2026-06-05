package br.com.rickicr_collab.WebSystemR.dto.usuario;

import br.com.rickicr_collab.WebSystemR.enums.Perfil;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO com informações de respostas das requisições do sistema!")
public record UsuarioResponseDTO(
    @Schema(description = "Indentificado gerado automaticamente pelo sistema!", example = "1")
    Long id,

    @Schema(description = "Nome completo do usuario cadastrado no sistema!", example = "Ricardo cunha")
    String nomeCompleto,

    @Schema(description = "Login do usuario cadastrado no sistema!", example = "ricardo.cunha")
    String login,

    @Schema(description = "Email do usuario cadastrado no sistema!", example = "ricardo.cunha@email.com")
    String email,

    @Schema(description = "Telefone do usuario cadastrado no sistema!", example = "11999999999")
    String telefone,

    @Schema(description = "Perfil do usuario cadastrado no sistema!", example = "ADMIN")
    Perfil perfil
) {

}
