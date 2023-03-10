package model.entidades;

import java.io.Serializable;

public class ModelLogin implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String senha;
	
	public ModelLogin(String username, String senha) {
		this.setSenha(senha);
		this.setUsername(username);
	}
	public ModelLogin() {}

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
	
}
