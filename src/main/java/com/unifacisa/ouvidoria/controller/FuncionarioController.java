package com.unifacisa.ouvidoria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @GetMapping("/home")
    public String funcionarioHome() {
        return "Bem-vindo, Funcionário!";
    }
}