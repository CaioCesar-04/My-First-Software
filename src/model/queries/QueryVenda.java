
package model.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.entidades.ModelVenda;

public class QueryVenda {
	public static void consultaVenda(Connection conecta) {
		Statement st = null;
		ResultSet rs = null;
		try {
		st = conecta.createStatement();
		rs = st.executeQuery("Select * from VENDA");
				while (rs.next()) {
					System.out.println(rs.getInt("Codigo")+rs.getFloat("Preco_total") + rs.getString("Forma_de_pagamento") 
					 +  rs.getString("FK_CLIENTE_Cpf_Cnpj")  + rs.getString("FK_VENDEDOR_User"));
					System.out.println(rs.getDate("Data"));
					System.out.println(rs.getBoolean("Situacao"));
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	}
	public static ModelVenda retornaVenda(Connection conecta, int codvenda) {
		ModelVenda modelVenda = new ModelVenda();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conecta.createStatement();
			rs= st.executeQuery("SELECT codigo,preco_total,data,fk_codcliente,desconto,preco_final FROM venda;");
			while(rs.next()){
				modelVenda.setCodVenda(rs.getInt(1));
				modelVenda.setPrecoTotal(rs.getDouble(2));
				modelVenda.setData(rs.getDate(3));;
				modelVenda.setCodCliente(rs.getInt(4));
				modelVenda.setDesconto(rs.getDouble(5));
				modelVenda.setPrecoFinal(rs.getDouble(6));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
		return modelVenda;
	}
	
	
	
	public static ArrayList<ModelVenda> retornarListaVendas(Connection conecta){
		ArrayList<ModelVenda> listaModelVendas = new ArrayList<>();
		ModelVenda modelVenda = new ModelVenda();
		Statement st = null;
		ResultSet rs = null;
		try {
			st= conecta.createStatement();
			rs = st.executeQuery("SELECT codigo,preco_total,data,fk_codcliente,desconto,preco_final FROM venda;"); 
			while(rs.next()) {
				modelVenda.setCodVenda(rs.getInt(1));
				modelVenda.setPrecoTotal(rs.getDouble(2));
				modelVenda.setData(rs.getDate(3));
				modelVenda.setCodCliente(rs.getInt(4));
				modelVenda.setDesconto(rs.getDouble(5));
				modelVenda.setPrecoFinal(rs.getDouble(6));
				listaModelVendas.add(modelVenda);
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
		return listaModelVendas;
	}
	
	
	
	
	public static boolean insereVenda (Connection conecta, ModelVenda modelVenda){
		
		PreparedStatement st = null;
		
		
		try {
		
			st=conecta.prepareStatement("INSERT INTO venda" + "(data,preco_total,fk_codcliente,desconto,preco_final)" + "VALUES" + "(?,?,?,?,?) ");
			
			
			
			st.setDate(1,modelVenda.getData());
			st.setDouble(2,modelVenda.getPrecoTotal());
			st.setInt(3, modelVenda.getCodCliente());
			st.setDouble(4, modelVenda.getDesconto());
			st.setDouble(5, modelVenda.getPrecoFinal());
			
			st.executeUpdate();
			return true;
			
			
		}
		catch(SQLException e ) {
			
			e.printStackTrace();	
			return false;
		} 
		finally {
			
			try {
				st.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
