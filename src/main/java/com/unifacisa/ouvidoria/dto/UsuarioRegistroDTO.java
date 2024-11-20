package com.unifacisa.ouvidoria.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Luiz imolementando LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRegistroDTO {
    private String username;
    private String password;
    private String role;
    
    // Felipe -> INI - adicionando atributos no DTO para implementar serviço de Rating ****
    
    private int age;
    private LocalDate dataDeCadastro;
    private int interacoes;
    
    // Felipe -> FIM - ********************************************************************
}