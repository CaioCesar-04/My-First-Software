package model.entidades;

public class ModelItensVendidos {
	private int produtos;
	private int venda;
	private int codItenVendido;
	private double proValor;
	private int  proQuant;
	
	
	public ModelItensVendidos(int produtos, int venda, int codItenVendido, double proValor, int proQuant) {
		super();
		this.produtos = produtos;
		this.venda = venda;
		this.codItenVendido = codItenVendido;
		this.proValor = proValor;
		this.proQuant = proQuant;
	}
	
	public ModelItensVendidos() {
		// TODO Auto-generated constructor stub
	}

	public int getProdutos() {
		return produtos;
	}
	public void setProdutos(int produtos) {
		this.produtos = produtos;
	}
	public int getVenda() {
		return venda;
	}
	public void setVenda(int venda) {
		this.venda = venda;
	}

	public int getProQuant() {
		return proQuant;
	}
	public void setProQuant(int proQuant) {
		this.proQuant = proQuant;
	}
	public int getCodItenVendido() {
		return codItenVendido;
	}
	public void setCodItenVendido(int codItenVendido) {
		this.codItenVendido = codItenVendido;
	}
	public double getProValor() {
		return proValor;
	}
	public void setProValor(double proValor) {
		this.proValor = proValor;
	}
}
