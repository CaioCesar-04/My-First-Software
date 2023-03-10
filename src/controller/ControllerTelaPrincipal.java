package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entidades.ModelCliente;
import model.entidades.ModelItensVendidos;
import model.entidades.ModelProdutos;
import model.entidades.ModelUsuario;
import model.entidades.ModelVenda;
import model.entidades.ModelVendasClientes;
import view.ViewCliente;
import view.ViewManipulaVenda;
import view.ViewPrincipal;
import view.ViewProduto;
import view.ViewUsuario;
import view.ViewVendas;

public class ControllerTelaPrincipal implements ActionListener{
	private ViewPrincipal tela;
	
	public ControllerTelaPrincipal(ViewPrincipal tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Clientes") {
			ViewCliente telaCliente = new ViewCliente();
			ModelCliente modelCliente= new ModelCliente();
			ControllerClientes clienteController = new ControllerClientes(telaCliente,modelCliente);
			telaCliente.setVisible(true);
			telaCliente.addActionListener(clienteController);
			
		}else if(e.getActionCommand()=="Produtos") {
			ViewProduto telaProduto = new ViewProduto();
			ModelProdutos modelProduto = new ModelProdutos();
			ControllerProdutos controllerProdutos = new ControllerProdutos(modelProduto,telaProduto); 
			telaProduto.setVisible(true);
			telaProduto.addActionListener(controllerProdutos);
			
		}else if(e.getActionCommand()=="Usuários") {
			ViewUsuario telaUsuario = new ViewUsuario();
			ModelUsuario modelUsuario = new ModelUsuario();
			ControllerUsuarios controllerUsuarios = new ControllerUsuarios(telaUsuario,modelUsuario);
			telaUsuario.setVisible(true);
			telaUsuario.addActionListener(controllerUsuarios);
		}else if(e.getActionCommand()=="Cadastro de Vendas") {
			ViewVendas telaVenda = new ViewVendas();
			ModelVenda modelVenda = new ModelVenda();
			ModelProdutos modelProdutos = new ModelProdutos();
			ModelItensVendidos modelItensVendidos = new ModelItensVendidos();
			ControllerProdutos controllerProdutos = new ControllerProdutos();
			ControllerItensVendidos controllerItensVendidos = new ControllerItensVendidos();
			ControllerVenda controllerVenda = new ControllerVenda(telaVenda,modelVenda,modelProdutos,controllerProdutos,controllerItensVendidos,modelItensVendidos);
			telaVenda.setVisible(true);
			telaVenda.addActionListener(controllerVenda);
			
		}else if(e.getActionCommand()=="Consultar Vendas") {
			ViewManipulaVenda telaManipulaVenda = new ViewManipulaVenda();
			ModelVendasClientes vendaCliente = new ModelVendasClientes();
			ControllerVendasClientes controllerVendaCliente = new ControllerVendasClientes(telaManipulaVenda,vendaCliente);
			telaManipulaVenda.setVisible(true);
			telaManipulaVenda.addActionListener(controllerVendaCliente);
			
		}else if(e.getActionCommand()=="VENDA") {
			ViewVendas telaVenda = new ViewVendas();
			ModelVenda modelVenda = new ModelVenda();
			ModelProdutos modelProdutos = new ModelProdutos();
			ModelItensVendidos modelItensVendidos = new ModelItensVendidos();
			ControllerProdutos controllerProdutos = new ControllerProdutos();
			ControllerItensVendidos controllerItensVendidos = new ControllerItensVendidos();
			ControllerVenda controllerVenda = new ControllerVenda(telaVenda,modelVenda,modelProdutos,controllerProdutos,controllerItensVendidos,modelItensVendidos);
			telaVenda.setVisible(true);
			telaVenda.addActionListener(controllerVenda);
			
		}else if(e.getActionCommand()=="CLIENTES") {
			ViewCliente telaCliente = new ViewCliente();
			ModelCliente modelCliente= new ModelCliente();
			ControllerClientes clienteController = new ControllerClientes(telaCliente,modelCliente);
			telaCliente.setVisible(true);
			telaCliente.addActionListener(clienteController);
			
		}else if(e.getActionCommand()=="PRODUTOS") {
			ViewProduto telaProduto = new ViewProduto();
			ModelProdutos modelProduto = new ModelProdutos();
			ControllerProdutos controllerProdutos = new ControllerProdutos(modelProduto,telaProduto); 
			telaProduto.setVisible(true);
			telaProduto.addActionListener(controllerProdutos);
			
			
		}else if(e.getActionCommand()=="USUÁRIOS") {
			ViewUsuario telaUsuario = new ViewUsuario();
			ModelUsuario modelUsuario = new ModelUsuario();
			ControllerUsuarios controllerUsuarios = new ControllerUsuarios(telaUsuario,modelUsuario);
			telaUsuario.setVisible(true);
			telaUsuario.addActionListener(controllerUsuarios);
			
		}
	}
	
}
