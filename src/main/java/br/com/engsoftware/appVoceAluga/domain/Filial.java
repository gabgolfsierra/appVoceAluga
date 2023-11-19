package br.com.engsoftware.appVoceAluga.domain;

import java.sql.Time;

public class Filial {

	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private Time horarioFuncionamento;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Time getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	public void setHorarioFuncionamento(Time horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
	
	
}
