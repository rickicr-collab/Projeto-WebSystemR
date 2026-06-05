package br.com.rickicr_collab.WebSystemR.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rickicr_collab.WebSystemR.dto.usuario.UsuarioRequestDTO;
import br.com.rickicr_collab.WebSystemR.dto.usuario.UsuarioResponseDTO;
import br.com.rickicr_collab.WebSystemR.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(
        summary = "Listar todos os usuarios cadastrados!",
        description = "Endpoint para listar todos os usuarios cadastrados no sistema"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200", description = "Lista de usuarios retornada com sucesso!"
        )
    })
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @Operation(
        summary = "Buscar usuario por ID", 
        description = "Endpoint para buscar um usuario atravez de seu ID"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso pelo ID informado"),
        @ApiResponse(responseCode = "404", description = "Usuario não encontrado com i ID informado!")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorID(@PathVariable Long id){
        UsuarioResponseDTO usuarioPorID = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuarioPorID);
    }


    @Operation(
        summary = "Criar um novo usuario",
        description = "Endpoint para criar um novo usuario no sistema, necessario informar dados requisitados no corpo da requisição"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso!"),
        @ApiResponse(responseCode = "409", description = "Conflito de email ou login já cadastrados no sistema!")
    })
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO criarUsuario = usuarioService.criarUsuario(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuario);
    }

    @Operation(
        summary = "Atualizar dados existentes de um usuario no sistema!",
        description = "Endpoint para atualizar dados de um usuario existente no sistema , necessario informar ID do usuario e dados a ser atualizados no corpo da requisição!"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "usuario atualizado com sucesso!"),
        @ApiResponse(responseCode = "404", description = "usuario não encontrado com o ID informado!")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario( @PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO dto){
        UsuarioResponseDTO usuarioAtualizado = usuarioService.atualizarUsuario(id, dto);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @Operation(
        summary = "Deletar um usuario existente no sistema!",
        description = "Endpoint para deletar um usuario cadastrado no sistema , buscando pelo ID do usuario a ser deletado!"
    )

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Usuario deletado com sucesso!"),
        @ApiResponse(responseCode = "404", description = "usuario não encontrado pelo ID informado!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
