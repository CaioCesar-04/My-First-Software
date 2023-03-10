package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import model.conexao.Conexao;
import model.entidades.ModelVendasClientes;
import model.queries.QueryVenda;
import model.queries.QueryVendasClientes;
import view.ViewManipulaVenda;

public class ControllerVendasClientes implements ActionListener {
	Connection con=Conexao.getConnection();
	
	private ViewManipulaVenda telaManipulaVenda;
	private ModelVendasClientes vendasClientes;
	public ControllerVendasClientes(ViewManipulaVenda telaManipulaVenda, ModelVendasClientes vendaCliente) {
		this.telaManipulaVenda=telaManipulaVenda;
		this.vendasClientes = vendaCliente;
	}

	
	public ControllerVendasClientes() {
		
	}


	public ArrayList<ModelVendasClientes> getListaVendaClientes() {
		return QueryVendasClientes.retornarListaVendasClientes(con);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
	

		
	}



}
