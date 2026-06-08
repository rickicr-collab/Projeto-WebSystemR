package br.com.rickicr_collab.WebSystemR.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rickicr_collab.WebSystemR.entity.Usuario;

@Service
public class UsuarioUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;

    public UsuarioUserDetailsService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario usuario = usuarioService.buscarPorLogin(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com login: " + username));
       return usuario;
    }
}
