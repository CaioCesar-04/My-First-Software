package model.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entidades.ModelCliente;
import model.entidades.ModelVenda;
import model.entidades.ModelVendasClientes;

public class QueryVendasClientes {
	
	public static ArrayList<ModelVendasClientes> retornarListaVendasClientes(Connection conecta){
		ArrayList<ModelVendasClientes> listaModelVendasClientes = new ArrayList<>();
		ModelVenda modelVenda = new ModelVenda();
		ModelCliente modelClientes = new ModelCliente();
		ModelVendasClientes modelVendasClientes = new ModelVendasClientes();
		Statement st = null;
		ResultSet rs = null;
		try {
			st= conecta.createStatement();
			rs = st.executeQuery("SELECT venda.codigo,venda.preco_total,venda.data,venda.fk_codcliente,venda.desconto,venda.preco_final,cliente.estado,cliente.email, cliente.cidade, cliente.nome_da_fazenda, cliente.nome, cliente.cpf_cnpj, cliente.inscricao_estadual,cliente.cep, cliente.id ,cliente.telefone, cliente.endereço FROM venda INNER JOIN cliente ON cliente.id = venda.fk_codcliente"); 
			while(rs.next()) {
				modelVenda = new ModelVenda();
				modelClientes = new ModelCliente();
				modelVendasClientes = new ModelVendasClientes();
				modelVenda.setCodVenda(rs.getInt(1));
				modelVenda.setPrecoTotal(rs.getDouble(2));
				modelVenda.setData(rs.getDate(3));
				modelVenda.setCodCliente(rs.getInt(4));
				modelVenda.setDesconto(rs.getDouble(5));
				modelVenda.setPrecoFinal(rs.getDouble(6));
				
				modelClientes.setEstado(rs.getString(7));
				modelClientes.setEmail(rs.getString(8));
				modelClientes.setCidade(rs.getString(9));
				modelClientes.setNomeFazenda(rs.getString(10));
				modelClientes.setNomeCliente(rs.getString(11));
				modelClientes.setCpf(rs.getString(12));
				modelClientes.setInscricaoEstadual(rs.getInt(13));
				modelClientes.setCep(rs.getString(14));
				modelClientes.setCodCliente(rs.getInt(15));	
				modelClientes.setTelefone(rs.getString(16));
				modelClientes.setEndereco(rs.getString(17));
				
				
				modelVendasClientes.setModelVenda(modelVenda);
				modelVendasClientes.setModelCliente(modelClientes);
				
				listaModelVendasClientes.add(modelVendasClientes);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		}
		return listaModelVendasClientes;
	}
}
