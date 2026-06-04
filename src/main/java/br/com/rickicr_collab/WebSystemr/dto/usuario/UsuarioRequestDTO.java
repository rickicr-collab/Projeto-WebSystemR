package br.com.rickicr_collab.WebSystemR.dto.usuario;

import br.com.rickicr_collab.WebSystemR.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

    @NotBlank(message = "O nome é obrigatorio!")
    @Size(min = 10, max = 100, message = "O nome deve conter entre 10 e 100 caracteres!")
    String nomeCompleto,

    @NotBlank(message = "O Login é obrigatório!")
    @Size(min = 5, max = 30, message = "O login deve conter entre 5 e 30 caracteres!")
    String login,

    @NotBlank(message = "A senha é obrigatoria!")
    @Size(min = 8, max = 255, message = "A senha deve conter entre 8 e 255 caracteres!")
    String senha,

    @NotBlank(message = "O email é obrigatorio!")
    @Email(message = "O email deve ser válido!")
    String email,

    String telefone,

    @NotNull(message = "O perfil é obrigatório!")
    Perfil perfil
) {

}
