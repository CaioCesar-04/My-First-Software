package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import util.Datas;
import model.conexao.Conexao;
import model.entidades.ModelItensVendidos;
import model.entidades.ModelProdutos;
import model.entidades.ModelVenda;
import model.queries.QueryVenda;
import view.ViewVendas;

public class ControllerVenda implements ActionListener {
	
	Datas setData = new Datas();
	Connection con=Conexao.getConnection();
	private ViewVendas telaVendas;
	private ModelVenda modelVenda;
	private ModelProdutos modelProdutos;
	private ControllerProdutos controllerProdutos;
	private ControllerItensVendidos controllerItensVendidos;
	private ModelItensVendidos modelItensVendidos;
	ArrayList<ModelItensVendidos> listaModelItensVendidos = new ArrayList<>();
	ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
	public ControllerVenda(ViewVendas telaVenda, ModelVenda modelVenda,ModelProdutos modelProdutos,ControllerProdutos controllerProdutos,ControllerItensVendidos controllerItensVendidos,ModelItensVendidos modelItensVendidos) {
		this.telaVendas = telaVenda;
		this.modelVenda = modelVenda;
		this.modelProdutos = modelProdutos;
		this.controllerProdutos = controllerProdutos;
		this.controllerItensVendidos = controllerItensVendidos;
		this.modelItensVendidos = modelItensVendidos;
	}
	public ControllerVenda() {}
	public boolean salvarVendaController(ModelVenda modelvenda) {
			return QueryVenda.insereVenda(con, modelvenda);
	}
	
	//retorna as vendas do banco
	public ModelVenda retornaVendaController (int codigo) {
		return QueryVenda.retornaVenda(con, codigo);
	}
	
	//retorna a lista de vendas para colocar na tela
	public ArrayList<ModelVenda> listaVenda(){
		return QueryVenda.retornarListaVendas(con);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Adicionar") {
			if(telaVendas.getTextQuantidade().getText().equals("")) {
				telaVendas.msgErroQuantidade();
			}else {
				modelProdutos=controllerProdutos.retornaProdutoController(Integer.parseInt(telaVendas.getTextCodProduto().getText()));
				DefaultTableModel modelo = (DefaultTableModel) telaVendas.getTable().getModel();
				int cont = 0;
				double quant  = 0;
				quant = Double.parseDouble(telaVendas.getTextQuantidade().getText());
				for(int i =0; i<cont; i++) {
					modelo.setNumRows(0);
				}
				modelo.addRow(new Object[] {
						modelProdutos.getCodProduto(),
						modelProdutos.getProNome(),
						telaVendas.getTextQuantidade().getText(),
						modelProdutos.getPrecoVista(),
						quant * modelProdutos.getPrecoVista(),
						quant * modelProdutos.getPrecoPrazo()
				});
				somarValorTotal();
				
			}
		}else if(e.getActionCommand()=="Limpar") {
			telaVendas.limparFormulario();
		}else if(e.getActionCommand()=="Salvar") {
			
			
			listaModelItensVendidos = new ArrayList<>();
			int codVenda = 0;
			modelVenda.setCodCliente(Integer.parseInt(telaVendas.getTextCodCliente().getText()));
			try {
				modelVenda.setData(setData.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			modelVenda.setPrecoFinal(Double.parseDouble(telaVendas.getTextValorTotal().getText()));
			double a =  Double.parseDouble(telaVendas.getTextValorTotal().getText());
			double b = Double.parseDouble(telaVendas.getTextDesconto().getText());
			modelVenda.setPrecoTotal(a+b);
			modelVenda.setDesconto(Double.parseDouble(telaVendas.getTextDesconto().getText()));
			
			if(salvarVendaController(modelVenda)){
				codVenda = retornaVendaController(modelVenda.getCodVenda()).getCodVenda();
				
				telaVendas.msgSalvado();
				
				
			}else {
				telaVendas.msgSalvadoErro();
			}
			int cont = telaVendas.getTable().getRowCount();
			for(int i = 0 ; i<cont;i++) {
				modelItensVendidos = new ModelItensVendidos();
				modelProdutos = new ModelProdutos();
				modelItensVendidos.setProdutos((int) telaVendas.getTable().getValueAt(i, 0));
				modelItensVendidos.setVenda(codVenda);
				modelItensVendidos.setProValor((double) telaVendas.getTable().getValueAt(i, 4));
				modelItensVendidos.setProQuant(Integer.parseInt(telaVendas.getTable().getValueAt(i, 2).toString()));
				
				modelProdutos.setCodProduto((int) telaVendas.getTable().getValueAt(i, 0));
				modelProdutos.setQtdEstoque(controllerProdutos.retornaProdutoController((int) telaVendas.getTable().getValueAt(i, 0)).getQtdEstoque()
						-Integer.parseInt(telaVendas.getTable().getValueAt(i, 2).toString()));
				listaModelItensVendidos.add(modelItensVendidos);
				listaModelProdutos.add(modelProdutos);
				
			}
			if(controllerItensVendidos.salvarItensVendidosController(listaModelItensVendidos)) {
				controllerProdutos.alterarEstoqueProdutoController(listaModelProdutos);
				telaVendas.msgProSalvo();
				telaVendas.limparFormulario();
			}
		
		}
		
	}

	
	private void somarValorTotal()
	{
		double soma = 0, valor;
		int cont = telaVendas.getTable().getRowCount();
		for(int i = 0; i<cont;i++) {
			valor = (double) telaVendas.getTable().getValueAt(i, 4);
			soma = soma + valor;
		}
		telaVendas.getTextValorTotal().setText(String.valueOf(soma));
	}

	

}
