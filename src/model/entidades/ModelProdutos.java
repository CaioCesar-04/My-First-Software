package model.entidades;



public class ModelProdutos {
	private int codProduto;
	private String proNome ;
	private double precoVista ;
	private double precoPrazo ;
	private String proEspecificacoes ;
	private int qtdEstoque ;
	
	
	public ModelProdutos(String proNome, double precoVista, double precoPrazo, String proEspecificacoes,
			int qtdEstoque) {
		super();
		this.proNome = proNome;
		this.precoVista = precoVista;
		this.precoPrazo = precoPrazo;
		this.proEspecificacoes = proEspecificacoes;
		this.qtdEstoque = qtdEstoque;
	}
	public ModelProdutos() {
		// TODO Auto-generated constructor stub
	}
	public int getCodProduto() {
		return this.codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String getProNome() {
		return this.proNome;
	}
	public void setProNome(String proNome) {
		this.proNome = proNome;
	}
	public double getPrecoVista() {
		return this.precoVista;
	}
	public void setPrecoVista(double precoVista) {
		this.precoVista = precoVista;
	}
	public double getPrecoPrazo() {
		return this.precoPrazo;
	}
	public void setPrecoPrazo(double precoPrazo) {
		this.precoPrazo = precoPrazo;
	}
	public String getProEspecificacoes() {
		return this.proEspecificacoes;
	}
	public void setProEspecificacoes(String proEspecificacoes) {
		this.proEspecificacoes = proEspecificacoes;
	}
	public int getQtdEstoque() {
		return this.qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

}
