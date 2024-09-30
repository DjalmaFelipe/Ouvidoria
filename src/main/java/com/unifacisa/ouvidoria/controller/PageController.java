package com.unifacisa.ouvidoria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Vai procurar login.html em /templates/
    }

    @GetMapping("/cadastro")
    public String showCadastroPage() {
        return "cadastro";  // Vai procurar cadastro.html em /templates/
    }
}
