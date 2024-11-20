package com.unifacisa.ouvidoria.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Luiz implementando LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="solicitacao")
public class Solicitacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="descricao")
    private String descricao;
    @Column(name="data")
    private LocalDateTime dataCriacao;
    @Column(name="resposta")
    private String resposta;
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name="nota")
    private int nota;

	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}