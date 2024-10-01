package com.unifacisa.ouvidoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.unifacisa.ouvidoria.entity.Solicitacao;
import com.unifacisa.ouvidoria.entity.Status;
import com.unifacisa.ouvidoria.entity.Usuario;
import com.unifacisa.ouvidoria.repository.SolicitacaoRepository;
import com.unifacisa.ouvidoria.repository.UsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/solicitacao")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Solicitacao criarSolicitacao(@RequestBody Solicitacao solicitacao, @AuthenticationPrincipal UserDetails userDetails) {
        Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        solicitacao.setUsuario(usuario);
        solicitacao.setDataCriacao(LocalDateTime.now());
        return solicitacaoRepository.save(solicitacao);
    }

    @GetMapping
    public List<Solicitacao> listarSolicitacoesUsuario(@AuthenticationPrincipal UserDetails userDetails) {
        Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        return solicitacaoRepository.findByUsuario(usuario);
    }
    
    
    @PostMapping("/{id}/responder")
    public ResponseEntity<?> responderSolicitacao(@PathVariable Long id, @RequestParam String resposta) {
        Solicitacao solicitacao = solicitacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Solicitação não encontrada."));
        solicitacao.setResposta(resposta);
        solicitacao.setStatus(Status.CONCLUIDO);
        solicitacaoRepository.save(solicitacao);
        return ResponseEntity.ok().build();
    }


}
