package br.com.rickicr_collab.WebSystemR.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rickicr_collab.WebSystemR.dto.usuario.UsuarioRequestDTO;
import br.com.rickicr_collab.WebSystemR.dto.usuario.UsuarioResponseDTO;
import br.com.rickicr_collab.WebSystemR.entity.Usuario;
import br.com.rickicr_collab.WebSystemR.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // metodo Lista Usuarios
    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(this::converterParaDTO).toList();
    }

    // Metodo Buscar Por Id
    public UsuarioResponseDTO buscarPorId(Long id) {
        var usuarioBuscado = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não Encontrado"));
        return converterParaDTO(usuarioBuscado);
    }

    // Metodo criar Usuario
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = converterParaEntidade(dto);
        if (usuarioRepository.existsByLogin(usuario.getLogin())) {
            throw new RuntimeException("Login já cadastrado!");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }
        Usuario usuarioCriado = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioCriado);
    }

    // Metodo deletar Usuario
    public void deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario não Encontrado com " + id + " informado!");
        }
    }

    // Conversor para Entidade
    private Usuario converterParaEntidade(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(dto.nomeCompleto());
        usuario.setLogin(dto.login());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setTelefone(dto.telefone());
        usuario.setPerfil(dto.perfil());
        return usuario;
    }
    
    // Conversor Para DTO
    private UsuarioResponseDTO converterParaDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNomeCompleto(),
                usuario.getLogin(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getPerfil());
    }

}
