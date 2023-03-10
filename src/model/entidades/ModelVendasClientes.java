package model.entidades;

import java.util.ArrayList;

public class ModelVendasClientes {
	
	private ModelVenda modelVenda;
	private ModelCliente modelCliente;
	private ArrayList<ModelVendasClientes> listaModelVendasClientes;
	
	
	public ModelVenda getModelVenda() {
		return modelVenda;
	}
	public void setModelVenda(ModelVenda modelVenda) {
		this.modelVenda = modelVenda;
	}
	public ModelCliente getModelCliente() {
		return modelCliente;
	}
	public void setModelCliente(ModelCliente modelCliente) {
		this.modelCliente = modelCliente;
	}
	public ArrayList<ModelVendasClientes> getListaModelVendasClientes() {
		return listaModelVendasClientes;
	}
	public void setListaModelVendasClientes(ArrayList<ModelVendasClientes> listaModelVendasClientes) {
		this.listaModelVendasClientes = listaModelVendasClientes;
	}
	

}
