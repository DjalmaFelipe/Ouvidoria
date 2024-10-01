package com.unifacisa.ouvidoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.unifacisa.ouvidoria.entity.Solicitacao;
import com.unifacisa.ouvidoria.entity.Status;
import com.unifacisa.ouvidoria.repository.SolicitacaoRepository;

import java.util.List;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @GetMapping
    public String exibirPaginaFuncionario() {
        return "funcionario";
    }

    @GetMapping("/solicitacoes")
    @ResponseBody
    public List<Solicitacao> listarSolicitacoes() {
        return solicitacaoRepository.findAll();
    }

    @PostMapping("/solicitacoes/{id}/concluir")
    public String concluirSolicitacao(@PathVariable Long id) {
        Solicitacao solicitacao = solicitacaoRepository.findById(id).orElseThrow();
        solicitacao.setStatus(Status.CONCLUIDO);
        solicitacaoRepository.save(solicitacao);
        return "redirect:/funcionario";
    }
}
