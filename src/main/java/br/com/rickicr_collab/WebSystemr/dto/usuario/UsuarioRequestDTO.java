package br.com.rickicr_collab.WebSystemR.dto.usuario;

import br.com.rickicr_collab.WebSystemR.enums.Perfil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(
    description = "DTO usado para criar ou atualizar um usuario, contendo os campos necessarios para realizar a operação de criação ou atualização de um usuario no sistema!"
)
public record UsuarioRequestDTO(

    @Schema(
        description = "Nome completo do usuario - obrigatorio, deve conter entre 10 e 100 caracteres",
        example = "Ricardo Cunha "
    )
    @NotBlank(message = "O nome é obrigatorio!")
    @Size(min = 10, max = 100, message = "O nome deve conter entre 10 e 100 caracteres!")
    String nomeCompleto,

    @Schema(
        description = "Login do usuario - obrigatorio, deve contrer entre 5 e 30 caracteres",
        example = "ricardo.cunha"
    )
    @NotBlank(message = "O Login é obrigatório!")
    @Size(min = 5, max = 30, message = "O login deve conter entre 5 e 30 caracteres!")
    String login,

    @Schema(
        description = "Senha do usuario - obrigatorio, deve conter entre 8 e 255 caracteres",
        example = "senhaSegura123"
    )
    @NotBlank(message = "A senha é obrigatoria!")
    @Size(min = 8, max = 255, message = "A senha deve conter entre 8 e 255 caracteres!")
    String senha,

    @Schema(
        description = "Email do usuario - obrigatorio, deve ser um email valido",
        example = "ricardo.cunha@email.com"
    )
    @NotBlank(message = "O email é obrigatorio!")
    @Email(message = "O email deve ser válido!")
    String email,

    @Schema(
        description = "Telefone do usuario - opcional, deve conter no maximo 20 caracteres",
        example = "11987654321"
    )
    @Size(max = 20, message = "O telefone de conter no maximo 20 caracteres!")
    String telefone,

    @Schema(
        description = "Perfil do usuario - obrigatorio, deve ser um dos seguintes valores: ADMIN, USER",
        example = "ADMIN"
    )
    @NotNull(message = "O perfil é obrigatório!")
    Perfil perfil
) {

}
