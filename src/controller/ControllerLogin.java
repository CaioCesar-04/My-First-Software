package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import excecoes.LoginException;
import model.conexao.Conexao;
import model.entidades.ModelUsuario;
import model.queries.QueryUsuario;
import view.ViewLogin;
import view.ViewPrincipal;

public class ControllerLogin implements ActionListener {
	private ModelUsuario modelUsuario;
	private ViewLogin tela;
	
	
	//ModelUsuario modelUsuario1;
	
	public ControllerLogin(ModelUsuario modelUsuario,ViewLogin tela) {
		this.modelUsuario = modelUsuario;
		this.tela = tela;
	}
	
	Connection con=Conexao.getConnection();
	public boolean validaUsuarioController(ModelUsuario modelUsuario) {
		return QueryUsuario.validaUsuario(con,modelUsuario);
		
	}
	
	public void gravaLogin(ModelUsuario user) throws LoginException {
	   ControlerSerializa controle = new ControlerSerializa(); 
	   try {
		   controle.serializar("./login01", user);
	   }
	   catch(Exception ex) {
		  throw new LoginException();
	   }
	}
	   
	public ModelUsuario pegalogin() throws LoginException  {
		
		ControlerSerializa controle1 = new ControlerSerializa();
	
		ModelUsuario user= new ModelUsuario();
		
		try {
			user=(ModelUsuario) controle1.deserializar("./login01");
			return user;
		}
	  catch (Exception ex) {
		  throw new LoginException();
	  	}
	}

	public void colocaNaTela(ModelUsuario user) {
		tela.getTextUser().setText(user.getUsername());
		tela.getPasswordField().setText(user.getSenha());
	}
	
	//public boolean VerificaBotaoSalvarLogin() {
		//return tela.SalvaLogin.isSelected();
	//}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="Último login") {
			modelUsuario=null;
			try {
				modelUsuario=this.pegalogin();
				this.colocaNaTela(modelUsuario);
			} catch (LoginException e1) {
				// TODO Auto-generated catch block
				tela.msgErro(e1.msgErroException());
			}
			
		}
		
		if(e.getActionCommand()=="Entrar") {

			modelUsuario.setUsername(tela.getTextUser().getText());
			modelUsuario.setSenha(String.valueOf(tela.getPasswordField().getPassword()));
		
			
			
			if(validaUsuarioController(modelUsuario)) {
				ViewPrincipal telaPrincipal = new ViewPrincipal();
				telaPrincipal.setVisible(true);
				ControllerTelaPrincipal controllerTelaPrincipal= new ControllerTelaPrincipal(telaPrincipal);
				telaPrincipal.addActionListener(controllerTelaPrincipal);
				try {
					this.gravaLogin(modelUsuario);
				} catch (LoginException e1) {
					// TODO Auto-generated catch block
					tela.msgErro(e1.msgErroException());
				}
				tela.setVisible(false);
			}else{
				tela.msgErroLogin();
			};
		}
	
	}
}

