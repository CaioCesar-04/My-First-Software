package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.conexao.Conexao;
import model.entidades.ModelProdutos;
import model.queries.QueryProduto;
import view.ViewProduto;

public class ControllerProdutos implements ActionListener{
	
	 Connection con=Conexao.getConnection();
	 private ModelProdutos modelProdutos;
	 private ViewProduto telaProdutos;
	 private String salvarAlterar;
	
	 
	 public ControllerProdutos(ModelProdutos modelProdutos, ViewProduto viewProduto) {
		 this.modelProdutos = modelProdutos;
		 this.telaProdutos = viewProduto;
	 }
	
	public ControllerProdutos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * SALVA UM PRODUTO NO BANCO DE DADOS
	 */
	public boolean salvarProdutoController(ModelProdutos modelProdutos) {
		 return QueryProduto.insereProduto(con, modelProdutos);
	/**
	 * BUSCA UM PRODUTO ESPECIFICO	
	 */
	}
	public ModelProdutos retornaProdutoController (int pCod) {
		return QueryProduto.retornaProduto(con, pCod);
	}
	public ModelProdutos retornaProdutoControllerPNome (String pNomeProduto) {
		return QueryProduto.retornaProdutoPNome(con, pNomeProduto);
	}
	/**
	 * 
	 * RETORNA LISTA DE PRODUTOS 
	 */
	public ArrayList<ModelProdutos> listaProdutos(){
		return QueryProduto.retornarListaProdutos(con);
	}
	public boolean excluirProdutoController(int pCod) {
		return QueryProduto.excluirProduto(con, pCod);
	}
	
	public boolean alterarProdutoController(ModelProdutos modelProdutos) {
		return QueryProduto.alteraProduto(con, modelProdutos);
	}
	public boolean alterarEstoqueProdutoController(ArrayList<ModelProdutos> listaModelProdutos) {
		return QueryProduto.alteraEstoqueProduto(con, listaModelProdutos);
	}
	
	
	public void salvarProduto() {
		try {
			modelProdutos.setProNome(telaProdutos.getTextPnome().getText());
			modelProdutos.setQtdEstoque(Integer.parseInt(telaProdutos.getTextEstoque().getText()));
			modelProdutos.setPrecoPrazo(Double.parseDouble(telaProdutos.getTextPprazo().getText()));
			modelProdutos.setPrecoVista(Double.parseDouble(telaProdutos.getTextPvista().getText()));
			modelProdutos.setProEspecificacoes(telaProdutos.getTextEspecificacoes().getText());
			
			if(salvarProdutoController(modelProdutos)) {
				
				telaProdutos.carregarProdutosTabela();
				telaProdutos.limparCampos();
				telaProdutos.habilitaCampos(false);
				
				telaProdutos.msgInserido();		}
			else {
				telaProdutos.msgInseridoErro();
			}
			
		}
			catch(Exception e){
				telaProdutos.msgInseridoErro();
		}
		
	}
	public void alterarProduto(){
		try {
			modelProdutos.setProNome(telaProdutos.getTextPnome().getText());
			modelProdutos.setQtdEstoque(Integer.parseInt(telaProdutos.getTextEstoque().getText()));
			modelProdutos.setPrecoPrazo(Double.parseDouble(telaProdutos.getTextPprazo().getText()));
			modelProdutos.setPrecoVista(Double.parseDouble(telaProdutos.getTextPvista().getText()));
			modelProdutos.setProEspecificacoes(telaProdutos.getTextEspecificacoes().getText());
			if(alterarProdutoController(modelProdutos)) {
				telaProdutos.msgAlterado();
				}else {
				telaProdutos.msgAlteradoErro();
			}
			telaProdutos.carregarProdutosTabela();
			telaProdutos.limparCampos();
			telaProdutos.habilitaCampos(false);
		}catch(Exception e) {
			telaProdutos.msgAlteradoErro();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Salvar") {
			if(salvarAlterar.equals("salvar")) {
				salvarProduto();
			}else if(salvarAlterar.equals("alterar")) {
				alterarProduto();
			}
			
		}else if(e.getActionCommand() == "Excluir") {
			int linha = telaProdutos.getTableProdutos().getSelectedRow();
			int codigoProduto =(int) telaProdutos.getTableProdutos().getValueAt(linha, 0);
			if(excluirProdutoController(codigoProduto)) {
				telaProdutos.msgDeletado();
			}else {
				telaProdutos.msgDeletadoErro();
			}
			telaProdutos.carregarProdutosTabela();
			
		}else if(e.getActionCommand() == "Alterar") {
			salvarAlterar = "alterar";
			telaProdutos.habilitaCampos(true);
			int linha = telaProdutos.getTableProdutos().getSelectedRow();
			try {
				int codProduto =(int) telaProdutos.getTableProdutos().getValueAt(linha, 0);
			
				//recupera os dados do banco 
				modelProdutos = retornaProdutoController(codProduto);
				//setar na interface
				telaProdutos.getTextCodProduto().setText(String.valueOf(modelProdutos.getCodProduto()));
				telaProdutos.getTextEspecificacoes().setText(modelProdutos.getProEspecificacoes());
				telaProdutos.getTextEstoque().setText(String.valueOf(modelProdutos.getQtdEstoque()));
				telaProdutos.getTextPnome().setText(modelProdutos.getProNome());
				telaProdutos.getTextPprazo().setText(String.valueOf(modelProdutos.getPrecoPrazo()));
				telaProdutos.getTextPvista().setText(String.valueOf(modelProdutos.getPrecoVista()));
			}catch(Exception exc) {
				telaProdutos.msgNotSelected();
				exc.printStackTrace();
			}
			
			
		}else if(e.getActionCommand() == "Pesquisar") {
			DefaultTableModel modelo = (DefaultTableModel) telaProdutos.getTableProdutos().getModel();
			final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
			telaProdutos.getTableProdutos().setRowSorter(classificador);
			String texto = telaProdutos.getTextPesquisa().getText();
			classificador.setRowFilter(RowFilter.regexFilter(texto, 1));
			
		}else if(e.getActionCommand() == "Cancelar") {
			telaProdutos.habilitaCampos(false);
			telaProdutos.limparCampos();
			telaProdutos.carregarProdutosTabela();
			
		}else if(e.getActionCommand() == "Novo") {
			telaProdutos.habilitaCampos(true);
			salvarAlterar = "salvar";
			
		}
		
	}

	
	


}