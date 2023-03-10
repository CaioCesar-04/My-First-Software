package controller;

import java.sql.Connection;
import java.util.ArrayList;

import model.conexao.Conexao;
import model.entidades.ModelItensVendidos;

import model.queries.QueryItensVendidos;


public class ControllerItensVendidos {
	Connection con=Conexao.getConnection();
	

	//Salva uma venda no banco de dados
	
	public boolean salvarItensVendidosController(ModelItensVendidos modelItensVendidos) {
			return QueryItensVendidos.insereItensVendidos(con, modelItensVendidos);
	}
	
	//retorna as vendas do banco
	public ModelItensVendidos retornaItensVendidosController (int codItemVendido) {
		return QueryItensVendidos.retornaItensVendidos(con, codItemVendido);
	}
	
	//retorna a lista de vendas para colocar na tela
	public ArrayList<ModelItensVendidos> listaItensVendidos(){
		return QueryItensVendidos.retornarListaItensVendidos(con);
	}
	
	//exclui vendas do banco
	
	public boolean excluirVendaController(int codItemVendido) {
		return QueryItensVendidos.excluirItensVendidos(con, codItemVendido);
		
	}
	
	public boolean alterarVendaController(ModelItensVendidos modelItensVendidos) {
		return QueryItensVendidos.alteraItensVendidos(con, modelItensVendidos);
	}

	public boolean salvarItensVendidosController(ArrayList<ModelItensVendidos> listaModelItensVendidos) {
		// TODO Auto-generated method stub
		return  QueryItensVendidos.salvarItensVendidosController(con,listaModelItensVendidos);
	}
}
