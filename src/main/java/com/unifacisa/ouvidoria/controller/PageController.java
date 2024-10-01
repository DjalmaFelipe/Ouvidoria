package com.unifacisa.ouvidoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  
    }

    @GetMapping("/cadastro")
    public String showCadastroPage() {
        return "cadastro"; 
    }
    
    @GetMapping("/solicitacao")
    public String showSolicitacaoPage() {
        return "solicitacao"; 
    }
}
