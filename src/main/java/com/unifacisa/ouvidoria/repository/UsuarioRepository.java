package com.unifacisa.ouvidoria.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.unifacisa.ouvidoria.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}

