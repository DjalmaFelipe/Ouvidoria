package com.unifacisa.ouvidoria.dto;

import java.time.LocalDate;

public class UsuarioRegistroDTO {
    private String username;
    private String password;
    private String role;
    
    // Felipe -> INI - adicionando atributos no DTO para implementar serviço de Rating ****
    
    private int age;
    private LocalDate dataDeCadastro;
    private int interacoes;
    
    // Felipe -> FIM - ********************************************************************
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
    
    
}