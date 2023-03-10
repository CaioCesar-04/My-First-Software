package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.conexao.Conexao;

import model.entidades.ModelUsuario;

import model.queries.QueryUsuario;
import view.ViewLogin;
import view.ViewPrincipal;
import view.ViewUsuario;

public class ControllerUsuarios implements ActionListener{
		private ViewUsuario tela;
		private  ModelUsuario modelUsuario;	   
		private String salvarAlterar;
		public ControllerUsuarios() {
			
		}
		public ControllerUsuarios(ViewUsuario tela, ModelUsuario user) {
			this.tela = tela;
			this.modelUsuario=user;
		}
		Connection con=Conexao.getConnection();
		/**
		 * 
		 * SALVA UM USUARIO NO BANCO DE DADOS
		 */
		public void salvarUsuarioController(ModelUsuario modelUsuario) {
			QueryUsuario.insereUsuario(con, modelUsuario);
		/**
		 * BUSCA UM USUARIO ESPECIFICO	
		 */
		}
		public ModelUsuario retornaUsuarioController (int uId) {
			return QueryUsuario.retornaUsuario(con, uId);
		}
		/**
		 * 
		 * RETORNA LISTA DE USUARIOS 
		 */
		public ArrayList<ModelUsuario> getListaUsuario(){
			return QueryUsuario.retornaListaUsuarios(con);
		}
		public void excluirUsuarioController(int uId) {
			QueryUsuario.excluirUsuario(con, uId);
		}
		
		public void alterarClienteController(ModelUsuario modelUsuario) {
			QueryUsuario.alteraUsuario(con, modelUsuario);
		}
		
		/**
		 * VALIDAR LOGIN E SENHA DO USUARIO
		 * @param modelUsuario
		 * @return
		 */
		public boolean validaUsuarioController(ModelUsuario modelUsuario) {
			return QueryUsuario.validaUsuario(con,modelUsuario);
			
		}
		
		public void salvarButton() {
			modelUsuario.setUsername(tela.getTextUsername().getText());
			modelUsuario.setNome(tela.getTextNome().getText());
			modelUsuario.setSenha(tela.getTextSenha().getText());
			salvarUsuarioController(modelUsuario);
			tela.carregarUsuarios();
			tela.habilitarCampos(false);
			tela.limparCampos();
		}
		public void alterarButton() {
			modelUsuario.setId(Integer.parseInt(tela.getTextCod().getText()));
			modelUsuario.setUsername(tela.getTextUsername().getText());
			modelUsuario.setNome(tela.getTextNome().getText());
			modelUsuario.setSenha(tela.getTextSenha().getText());
			alterarClienteController(modelUsuario);
			tela.carregarUsuarios();
			tela.habilitarCampos(false);
			tela.limparCampos();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			 if(e.getActionCommand()=="Novo") {
				salvarAlterar = "salvar";
				tela.habilitarCampos(true);
				
			}else if(e.getActionCommand()=="Cancelar") {
				tela.habilitarCampos(false);
				tela.limparCampos();
			}else if(e.getActionCommand()=="Excluir") {
				int linha = tela.getTableUsuarios().getSelectedRow();
				int codUser = (int) tela.getTableUsuarios().getValueAt(linha,0);
			 	excluirUsuarioController(codUser);
				tela.carregarUsuarios(); 
				tela.habilitarCampos(false);
			}else if(e.getActionCommand()=="Alterar") {
				salvarAlterar = "alterar";
				tela.habilitarCampos(true);
				int linha = tela.getTableUsuarios().getSelectedRow();
				try {
					int codUser = (int) tela.getTableUsuarios().getValueAt(linha,0);
					
					
					modelUsuario = retornaUsuarioController(codUser);
					
					tela.getTextCod().setText(String.valueOf(modelUsuario.getId()));
					tela.getTextNome().setText(modelUsuario.getNome());
					tela.getTextUsername().setText(modelUsuario.getUsername());
					tela.getTextSenha().setText(modelUsuario.getSenha());
					
			 	}catch(Exception exc){
					tela.msgNotSelected();
					exc.printStackTrace();
				}
			}else if(e.getActionCommand()=="Salvar") {
				if(salvarAlterar.equals("salvar")) {
					this.salvarButton();
				}else if(salvarAlterar.equals("alterar")) {
					this.alterarButton();
				}
			}
			
		}
	
}
