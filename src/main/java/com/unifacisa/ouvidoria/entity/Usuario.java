package com.unifacisa.ouvidoria.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Luiz implementando LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "usuario")
    private String username;
    @Column(name = "senha")
    private String password;
    @Column(name = "funcao")
    private String role;
    
    // Felipe -> INI - adicionando atributos para acrescentar o modelo de rating *********
    @Column(name = "idade")
    private int age;
    @Column(name = "data_de_cadastro")
    private LocalDate dataDeCadastro;
    @Column(name = "interacoes")
    private int interacoes;
    @Column(name = "media_avaliacoes")
    private double mediaAvaliacoes;
    
    public double getTempoDeCadastro() {
    	LocalDate dataAtual = LocalDate.now();
        long anosInteiros = ChronoUnit.YEARS.between(this.dataDeCadastro, dataAtual);
        double anosComDecimal = anosInteiros + (double) ChronoUnit.DAYS.between(this.dataDeCadastro, dataAtual) / 365.25;
        return anosComDecimal;
    }
    // Felipe -> FIM - *******************************************************************

}