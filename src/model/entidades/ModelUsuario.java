package model.entidades;

import java.io.Serializable;

public class ModelUsuario implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String nome;
	private String senha;

	
	public ModelUsuario(int id, String username, String senha,String nome) {
		
		this.setId(id);
		this.setSenha(senha);
		this.setUsername(username);
		this.setNome(nome);
	}
	public ModelUsuario() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
