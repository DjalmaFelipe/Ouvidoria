package com.unifacisa.ouvidoria.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unifacisa.ouvidoria.entity.Usuario;
import com.unifacisa.ouvidoria.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados
        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Converte o role de string para uma lista de GrantedAuthority
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(usuario.getRole()));

        // Retorna um UserDetails com username, password e authorities
        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }
}
