package com.unifacisa.ouvidoria.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    // Felipe -> FIM - *******************************************************************
    
    public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}
	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	public int getInteracoes() {
		return interacoes;
	}
	public void setInteracoes(int interacoes) {
		this.interacoes = interacoes;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	} 

}
