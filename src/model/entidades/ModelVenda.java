package model.entidades;

import java.sql.Date;

public class ModelVenda {
private int codVenda;
private double precoTotal;
private Date data;

private int codCliente;
private double desconto;
private double precoFinal;


public ModelVenda(double precoTotal, Date data, int codCliente, int codVenda,double desconto,
		double precoFinal) {
	
	
	this.setPrecoTotal(precoTotal);
	this.setData(data);
	this.setCodCliente(codCliente);
	this.setCodVenda(codVenda);
	this.setDesconto(desconto);
	this.setPrecoFinal(precoFinal);
}

public ModelVenda() {
	// TODO Auto-generated constructor stub
}

public int getCodVenda() {
	return codVenda;
}

public void setCodVenda(int codVenda) {
	this.codVenda = codVenda;
}

public double getPrecoTotal() {
	return precoTotal;
}

public void setPrecoTotal(double precoTotal) {
	this.precoTotal = precoTotal;
}

public Date getData() {
	return data;
}

public void setData(Date data) {
	this.data = data;
}



public int getCodCliente() {
	return codCliente;
}

public void setCodCliente(int codCliente) {
	this.codCliente = codCliente;
}

public double getDesconto() {
	return desconto;
}

public void setDesconto(double desconto) {
	this.desconto = desconto;
}

public double getPrecoFinal() {
	return precoFinal;
}

public void setPrecoFinal(double precoFinal) {
	this.precoFinal = precoFinal;
}











}
