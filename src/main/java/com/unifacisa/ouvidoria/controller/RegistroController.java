package com.unifacisa.ouvidoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ouvidoria.dto.UsuarioRegistroDTO;
import com.unifacisa.ouvidoria.entity.Usuario;
import com.unifacisa.ouvidoria.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/registro")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String registrarNovoUsuario(@RequestBody UsuarioRegistroDTO usuarioDTO) {
        // Verificar se o usuário já existe
        if (usuarioRepository.findByUsername(usuarioDTO.getUsername()).isPresent()) {
            return "Usuário já existe!";
        }

        // Codificar a senha
        String senhaCodificada = passwordEncoder.encode(usuarioDTO.getPassword());

        // Criar o novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(usuarioDTO.getUsername());
        novoUsuario.setPassword(senhaCodificada);
        novoUsuario.setRole(usuarioDTO.getRole());

        // Salvar no banco de dados
        usuarioRepository.save(novoUsuario);

        return "Usuário registrado com sucesso!";
    }
}

