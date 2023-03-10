package model.entidades;

public class ModelCliente {
	private int codcliente;
	private String cpfCnpj;
	private String nomeCliente;
	private String email;
	private String nomeFazenda;
	private int inscricaoEstadual;
	private String cep;
	private String cidade;
	private String estado;
	private String telefone;
	private String endereco;
	public ModelCliente(int codcliente, String cpf, String nomeCliente, String email, String nomeFazenda,
			int inscricaoEstadual, String cep, String cidade, String estado,String telefone, String endereco) {
		super();		
		this.setCodCliente(codcliente);
		this.setCpf(cpf);
		this.setNomeCliente(nomeCliente);
		this.setEmail(email);
		this.setNomeFazenda(nomeFazenda);
		this.setInscricaoEstadual(inscricaoEstadual);
		this.setCep(cep);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
	}
	public ModelCliente() {
		// TODO Auto-generated constructor stub
	}
	public int getCodcliente() {
		return codcliente;
	}
	public void setCodCliente(int codcliente) {
		this.codcliente = codcliente;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpf(String cpf) {
		this.cpfCnpj = cpf;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeFazenda() {
		return nomeFazenda;
	}
	public void setNomeFazenda(String nomeFazenda) {
		this.nomeFazenda = nomeFazenda;
	}
	public int getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(int inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cliente [codcliente=" + codcliente + ", cpf=" + cpfCnpj + ", nomeCliente=" + nomeCliente + ", email="
				+ email + ", nomeFazenda=" + nomeFazenda + ", inscricaoEstadual=" + inscricaoEstadual + ", endereco="
				+ cep + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

}
