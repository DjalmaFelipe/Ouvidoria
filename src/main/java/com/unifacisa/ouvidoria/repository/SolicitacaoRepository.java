package com.unifacisa.ouvidoria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.unifacisa.ouvidoria.entity.Solicitacao;
import com.unifacisa.ouvidoria.entity.Usuario;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
    List<Solicitacao> findByUsuario(Usuario usuario);
}
