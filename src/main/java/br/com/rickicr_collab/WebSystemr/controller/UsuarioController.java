package br.com.rickicr_collab.WebSystemR.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rickicr_collab.WebSystemR.dto.usuario.UsuarioRequestDTO;
import br.com.rickicr_collab.WebSystemR.dto.usuario.UsuarioResponseDTO;
import br.com.rickicr_collab.WebSystemR.service.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorID(@PathVariable Long id){
        UsuarioResponseDTO usuarioPorID = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuarioPorID);
    }


    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO criarUsuario = usuarioService.criarUsuario(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuario);
    }

}
