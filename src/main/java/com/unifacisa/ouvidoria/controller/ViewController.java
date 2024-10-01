package com.unifacisa.ouvidoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/solicitacoes")
    public String exibirFormularioSolicitacao(Model model) {
        return "solicitacao"; 
    }
}
