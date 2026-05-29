package br.com.rickicr_collab.WebSystemR.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rickicr_collab.WebSystemR.entity.Usuario;
import br.com.rickicr_collab.WebSystemR.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // metodo Lista Usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    //Metodo Buscar Por Id
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não Encontrado"));
    }

    // Metodo criar Usuario
    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByLogin(usuario.getLogin())) {
            throw new RuntimeException("Login já cadastrado!");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }

    // Metodo deletar Usuario
    public void deletarUsuario(long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario não Encontrado com " + id + " informado!");
        }
    }

}
