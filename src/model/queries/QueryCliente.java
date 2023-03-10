package model.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;



import model.entidades.ModelCliente;
import model.entidades.ModelProdutos;
/**
 * busca os clientes no banco de dados
 * @author PICHAU
 *
 */
public class QueryCliente {
	public static void consultaCliente(Connection conecta) {
		//Connection conecta = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			//conecta = Conexao.getConnection();
			st = conecta.createStatement();
			rs = st.executeQuery("Select * from CLIENTE");
			while (rs.next()) {
				System.out.println(rs.getString("Cpf_Cnpj") +","+  rs.getString("Nome") + ", "
						+ rs.getInt("Inscricao_estadual") + ", " + rs.getString("Estado") + ", " + rs.getString("Email")
						+ ", " + rs.getString("CEP") + ", " + rs.getString("Nome_da_fazenda") + ", "
						+ rs.getString("Telefone") + ", " + rs.getString("Endereço")+rs.getInt("Id")+rs.getString("Cidade"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}

			//	Conexao.closeConnection();

			} catch (SQLException e) {

				e.printStackTrace();
			}
			
		
		}
	}
	/**
	 * RETORNA UM CLIENTE PELO CODIGO
	 */
	public static ModelCliente retornaCliente(Connection conecta,int cId) {
		ModelCliente modelCliente = new ModelCliente();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conecta.createStatement();
			rs = st.executeQuery("SELECT estado, email, cidade, nome_da_fazenda, nome, cpf_cnpj, inscricao_estadual,cep, telefone, endereço, id FROM cliente WHERE id ='"+ cId +"';"); 
			while(rs.next()) {
				modelCliente = new ModelCliente(); 
				modelCliente.setEstado(rs.getString(1));
				modelCliente.setEmail(rs.getString(2));
				modelCliente.setCidade(rs.getString(3));
				modelCliente.setNomeFazenda(rs.getString(4));
				modelCliente.setNomeCliente(rs.getString(5));
				modelCliente.setCpf(rs.getString(6));
				modelCliente.setInscricaoEstadual(rs.getInt(7));
				modelCliente.setCep(rs.getString(8));
				modelCliente.setTelefone(rs.getString(9));
				modelCliente.setEndereco(rs.getString(10));
				modelCliente.setCodCliente(rs.getInt(11));	
			}
			
		}catch(Exception e){
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
		return modelCliente; 
	}
		
	
	public static ModelCliente retornaClientePNome(Connection conecta,String pNomeCliente) {
		ModelCliente modelCliente = new ModelCliente();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conecta.createStatement();
			rs = st.executeQuery("SELECT estado, email, cidade, nome_da_fazenda, nome, cpf_cnpj, inscricao_estadual,cep, telefone, endereço, id FROM cliente WHERE nome ='"+ pNomeCliente +"';"); 
			while(rs.next()) {
				modelCliente = new ModelCliente(); 
				modelCliente.setEstado(rs.getString(1));
				modelCliente.setEmail(rs.getString(2));
				modelCliente.setCidade(rs.getString(3));
				modelCliente.setNomeFazenda(rs.getString(4));
				modelCliente.setNomeCliente(rs.getString(5));
				modelCliente.setCpf(rs.getString(6));
				modelCliente.setInscricaoEstadual(rs.getInt(7));
				modelCliente.setCep(rs.getString(8));
				modelCliente.setTelefone(rs.getString(9));
				modelCliente.setEndereco(rs.getString(10));
				modelCliente.setCodCliente(rs.getInt(11));	
			}
			
		}catch(Exception e){
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
		return modelCliente; 
	}
	
	/**
	 * RETORNA UMA LISTA DE CLIENTES
	 */
	public static ArrayList<ModelCliente> retornarListaClientes(Connection conecta){
		ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
		ModelCliente modelCliente= new ModelCliente();
		Statement st = null;
		ResultSet rs = null;
		try {
			st= conecta.createStatement();
			rs = st.executeQuery("SELECT estado, email, cidade, nome_da_fazenda, nome, cpf_cnpj, inscricao_estadual, id, cep, telefone, endereço FROM cliente;"); 
			while(rs.next()) {
				modelCliente = new ModelCliente(); 
				modelCliente.setEstado(rs.getString(1));
				modelCliente.setEmail(rs.getString(2));
				modelCliente.setCidade(rs.getString(3));
				modelCliente.setNomeFazenda(rs.getString(4));
				modelCliente.setNomeCliente(rs.getString(5));
				modelCliente.setCpf(rs.getString(6));
				modelCliente.setInscricaoEstadual(rs.getInt(7));
				modelCliente.setCodCliente(rs.getInt(8));
				modelCliente.setCep(rs.getString(9));
				modelCliente.setTelefone(rs.getString(10));
				modelCliente.setEndereco(rs.getString(11));
				listaModelClientes.add(modelCliente);
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
		return listaModelClientes;
	}
	/**
	 * INSERE UM CLIENTE NO BANCO DE DADOS
	 */
	public static boolean insereCliente(Connection conecta, ModelCliente modelCliente) {
		
		PreparedStatement st = null;
		
		try {
			
			st=conecta.prepareStatement("INSERT INTO cliente" +"(cpf_cnpj, nome, inscricao_estadual, estado, email, endereço, nome_da_fazenda ,cidade,cep,telefone)" +"VALUES" + "(?,?,?,?,?,?,?,?,?,?)");
			
			st.setString(1, modelCliente.getCpfCnpj());
			st.setString(2, modelCliente.getNomeCliente());
			st.setInt(3, modelCliente.getInscricaoEstadual() );
			st.setString(4, modelCliente.getEstado());
			st.setString(5, modelCliente.getEmail());
			st.setString(6, modelCliente.getEndereco());
			st.setString(7, modelCliente.getNomeFazenda());
			st.setString(8, modelCliente.getCidade());
			st.setString(9, modelCliente.getCep());
			st.setString(10, modelCliente.getTelefone());
			
			st.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			//Conexao.closeConnection();
			try {
				st.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	/**
	 * ALTERA AS INFORMAÇÕES DESEJADAS DE UM CLIENTE NO BANCO DE DADOS
	 */
	public static boolean alteraCliente(Connection conecta,ModelCliente modelCliente) {
		Statement st =null;
		
		try {
			st = conecta.createStatement();
			st.executeUpdate("UPDATE cliente SET estado = '" + modelCliente.getEstado() +"', email = '" + modelCliente.getEmail() + "', cidade = '" + modelCliente.getCidade() + "', nome_da_fazenda = '" + modelCliente.getNomeFazenda() + "', nome = '" + modelCliente.getNomeCliente() + "', cpf_cnpj = '" + modelCliente.getCpfCnpj() + "', inscricao_estadual = '" + modelCliente.getInscricaoEstadual() + "', cep = '" + modelCliente.getCep() + "', telefone = '" + modelCliente.getTelefone() + "', endereço = '" + modelCliente.getEndereco() + "' WHERE id = '" + modelCliente.getCodcliente() +"'");
			
			
			
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * EXCLUI AS INFORMAÇÕES DE UM CLIENTE NO BANCO DE DADOS
	 */
	public static boolean excluirCliente(Connection conecta, int cId) {
		Statement st =null;
		
		try {
			st=conecta.createStatement();
			st.executeUpdate("DELETE FROM cliente WHERE id = '"+ cId +"'");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			
			try {
				st.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	

}
