package com.unifacisa.ouvidoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unifacisa.ouvidoria.service.ChurnService;

@RestController
@RequestMapping("/api/churn")
public class ChurnController {

    @Autowired
    private ChurnService churnService;

    @GetMapping("/prever")
    public ResponseEntity<String> preverChurn(@RequestParam String nome) {
    	String resultado = churnService.preverChurn(nome);
        return ResponseEntity.ok(resultado);
    }
}

