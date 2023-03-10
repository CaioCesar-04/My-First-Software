package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.conexao.Conexao;
import model.entidades.ModelCliente;
import model.queries.QueryCliente;
import view.ViewCliente;


public class ControllerClientes implements ActionListener {
	Connection con=Conexao.getConnection();
	private ViewCliente telaCliente;
	private ModelCliente modelClientes;
	private String salvarAlterar;
	public ControllerClientes(ViewCliente telaCliente,ModelCliente cliente) {
		this.telaCliente=telaCliente;
		this.modelClientes = cliente;
	}
	public ControllerClientes() {
		
	}
	/**
	 * 
	 * SALVA UM PRODUTO NO BANCO DE DADOS
	 */
	public boolean salvarClienteController(ModelCliente modelCliente) {
		 return QueryCliente.insereCliente(con, modelCliente);
	/**
	 * BUSCA UM PRODUTO ESPECIFICO	
	 */
	}
	public ModelCliente retornaClienteController (int cCod) {
		return QueryCliente.retornaCliente(con, cCod);
	}
	
	public ModelCliente retornaClienteControllerPNome (String cNomeCliente) {
		return QueryCliente.retornaClientePNome(con, cNomeCliente);
	}
	/**
	 * 
	 * RETORNA LISTA DE PRODUTOS 
	 */
	public ArrayList<ModelCliente> listaClientes(){
		return QueryCliente.retornarListaClientes(con);
	}
	/**
	 * MANDA QUAL CLIENTE DEVE SER EXCLUIDO PELO CODIGO
	 */
	public boolean excluirClienteController(int cCod) {
		 return QueryCliente.excluirCliente(con, cCod);
	}
	
	/**
	 * ALTERA O CLIENTE SELECIONADO 
	 */
	public boolean alterarClienteController(ModelCliente modelCliente) {
		return QueryCliente.alteraCliente(con, modelCliente);
	}
	
	private void salvarCliente() {
		modelClientes.setNomeCliente(telaCliente.getTextNome().getText());
		modelClientes.setCep(telaCliente.getTextCep().getText());
		modelClientes.setCidade(telaCliente.getTextCidade().getText());
		modelClientes.setCpf(telaCliente.getTextCpfCnpj().getText());
		modelClientes.setEmail(telaCliente.getTextEmail().getText());
		modelClientes.setInscricaoEstadual(Integer.parseInt(telaCliente.getTextIE().getText()));
		modelClientes.setEndereco(telaCliente.getTextEndereco().getText());
		modelClientes.setEstado(telaCliente.getComboBoxEstados().getSelectedItem().toString());
		modelClientes.setNomeFazenda(telaCliente.getTextNFazenda().getText());
		modelClientes.setTelefone(telaCliente.getTextFone().getText());
		
		if(salvarClienteController(modelClientes)) {
			telaCliente.msgInserido();
		}else {
			telaCliente.msgInseridoErro();
		}
		telaCliente.carregarClienteTabela(); 
		telaCliente.limparCampos();
		telaCliente.habilitaCampos(false);
	}
	private void alterarCliente() {
		modelClientes.setNomeCliente(telaCliente.getTextNome().getText());
		modelClientes.setCep(telaCliente.getTextCep().getText());
		modelClientes.setCidade(telaCliente.getTextCidade().getText());
		modelClientes.setCpf(telaCliente.getTextCpfCnpj().getText());
		modelClientes.setEmail(telaCliente.getTextEmail().getText());
		modelClientes.setInscricaoEstadual(Integer.parseInt(telaCliente.getTextIE().getText()));
		modelClientes.setEndereco(telaCliente.getTextEndereco().getText());
		modelClientes.setEstado(telaCliente.getComboBoxEstados().getSelectedItem().toString());
		modelClientes.setNomeFazenda(telaCliente.getTextNFazenda().getText());
		modelClientes.setTelefone(telaCliente.getTextFone().getText());
		
		if(alterarClienteController(modelClientes)) {
			telaCliente.msgAlterado();
		}else {
			telaCliente.msgAlteradoErro();
		}
		telaCliente.carregarClienteTabela(); 
		telaCliente.limparCampos();
		telaCliente.habilitaCampos(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Salvar") {
			if(salvarAlterar.equals("salvar")) {
				this.salvarCliente();
			}else if(salvarAlterar.equals("alterar")) {
				this.alterarCliente();
			}
		}else if(e.getActionCommand()=="Alterar"){
			salvarAlterar = "alterar";
			telaCliente.habilitaCampos(true);
			int linha = telaCliente.getJtCliente().getSelectedRow();
			try {
				int codCliente = (int) telaCliente.getJtCliente().getValueAt(linha,0);
				
				
				modelClientes = retornaClienteController(codCliente);
				
				telaCliente.getTextCep().setText(modelClientes.getCep());
				telaCliente.getTextCidade().setText(modelClientes.getCidade());
				telaCliente.getTextCod().setText( String.valueOf(modelClientes.getCodcliente()));
				telaCliente.getTextCpfCnpj().setText(modelClientes.getCpfCnpj());
				telaCliente.getTextEmail().setText(modelClientes.getEmail());
				telaCliente.getTextEndereco().setText(modelClientes.getEndereco());
				telaCliente.getTextFone().setText(modelClientes.getTelefone());
				telaCliente.getTextIE().setText(String.valueOf(modelClientes.getInscricaoEstadual()));
				telaCliente.getTextNFazenda().setText(modelClientes.getNomeFazenda());
				telaCliente.getTextNome().setText(modelClientes.getNomeCliente());
			}catch(Exception exc){
				telaCliente.msgNotSelected();
				exc.printStackTrace();
			}
			
		}else if(e.getActionCommand()=="Novo") {
			salvarAlterar = "salvar";
			telaCliente.habilitaCampos(true);
			
			
		}else if(e.getActionCommand()=="Cancelar") {
			telaCliente.limparCampos();
			telaCliente.habilitaCampos(false);
		}else if (e.getActionCommand()=="Excluir") {
			int linha = telaCliente.getJtCliente().getSelectedRow();
			String codCliente1 = telaCliente.getJtCliente().getValueAt(linha,0).toString();
			int codCliente= Integer.parseInt(codCliente1);
			if(excluirClienteController(codCliente)) {
				telaCliente.msgDeletado();
			}else {
				telaCliente.msgDeletadoErro();
			}
			telaCliente.carregarClienteTabela(); 
			telaCliente.habilitaCampos(false);
			
		}
		
	}

}
