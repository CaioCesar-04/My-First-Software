package app;


import java.sql.Connection;

import controller.ControllerLogin;
import controller.ControllerUsuarios;
import model.conexao.Conexao;
import model.entidades.ModelProdutos;
import model.entidades.ModelUsuario;
import model.queries.QueryProduto;
import view.ViewCliente;
import view.ViewLogin;
import view.ViewPrincipal;
import view.ViewProduto;
import view.ViewUsuario;

public class App {

	//private static Conexao conectar = null;
	
	public static void main(String[] args) {
		
			
		
		try {
			
			ViewLogin tela = new ViewLogin();
			ModelUsuario user = new ModelUsuario();
			ControllerLogin login = new ControllerLogin(user,tela);
			
			
			//login.verificaSerialização();
		    tela.setVisible(true);
		    tela.addActionListener(login);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
	}
	
}


	
	
