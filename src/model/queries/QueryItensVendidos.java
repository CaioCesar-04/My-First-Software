package model.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entidades.ModelItensVendidos;


public class QueryItensVendidos {
	
	public static ModelItensVendidos retornaItensVendidos(Connection conecta, int codItenVendido) {
		ModelItensVendidos modelItensVendidos = new ModelItensVendidos();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conecta.createStatement();
			rs= st.executeQuery("SELECT fk_produto,fk_venda,pk_id_itensvendidos,pro_valor,pro_quant FROM itensvendidos;");
			while(rs.next()){
				modelItensVendidos.setProdutos(rs.getInt(1));
				modelItensVendidos.setVenda(rs.getInt(2));
				modelItensVendidos.setCodItenVendido(rs.getInt(3));
				modelItensVendidos.setProValor(rs.getDouble(4));
				modelItensVendidos.setProQuant(rs.getInt(5));
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
		return modelItensVendidos;
	}
	
	
	
	public static ArrayList<ModelItensVendidos> retornarListaItensVendidos(Connection conecta){
		ArrayList<ModelItensVendidos> listaModelItensVendidos = new ArrayList<>();
		ModelItensVendidos modelItensVendidos = new ModelItensVendidos();
		Statement st = null;
		ResultSet rs = null;
		try {
			st= conecta.createStatement();
			rs = st.executeQuery("SELECT fk_produto,fk_venda,pk_id_itensvendidos,pro_valor,pro_quant FROM itensvendidos;"); 
			while(rs.next()) {
				modelItensVendidos.setProdutos(rs.getInt(1));
				modelItensVendidos.setVenda(rs.getInt(2));
				modelItensVendidos.setCodItenVendido(rs.getInt(3));
				modelItensVendidos.setProValor(rs.getDouble(4));
				modelItensVendidos.setProQuant(rs.getInt(5));
				listaModelItensVendidos.add(modelItensVendidos);
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
		return listaModelItensVendidos;
	}
	
	
	
	
	public static boolean insereItensVendidos (Connection conecta, ModelItensVendidos modelItensVendidos){
		
		PreparedStatement st = null;
		
		
		try {
		
			st=conecta.prepareStatement("INSERT INTO itensvendidos (fk_produto,fk_venda,pro_valor,pro_quant) VALUES (?,?,?,?)");
			
			
			st.setInt(1,modelItensVendidos.getProdutos());
			st.setInt(2,modelItensVendidos.getVenda());
			st.setDouble(3,modelItensVendidos.getProValor());
			st.setInt(4,modelItensVendidos.getProQuant());
					
			
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
	
	
	
	public static boolean alteraItensVendidos(Connection conecta, ModelItensVendidos itensVendidos) {
		PreparedStatement st =null;
		try {
			st = conecta.prepareStatement("UPDATE venda SET fk_produto = '" + itensVendidos.getProdutos() + "', fk_venda = '" + itensVendidos.getVenda()+"', pro_valor = '" +  itensVendidos.getProValor()+"', pro_quant= '"+ itensVendidos.getProQuant()+"' WHERE pk_id_itensvendidos = '"+ itensVendidos.getCodItenVendido() + "'");
			return true;
			
		}catch(SQLException e)
		{
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
		
	
	
	
	public static boolean excluirItensVendidos(Connection conecta, int codItenVendido) {
		Statement st =null;
		
		try {
			st=conecta.createStatement();
			st.executeUpdate("DELETE FROM itensvendidos WHERE pk_id_itensvendidos = '"+ codItenVendido +"'");
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



	public static boolean salvarItensVendidosController(Connection conecta,ArrayList<ModelItensVendidos> listaModelItensVendidos) {
		PreparedStatement st = null;
		
		
		try {
			int cont = listaModelItensVendidos.size();
			for(int i = 0 ; i<cont;i++) {
				st=conecta.prepareStatement("INSERT INTO itensvendidos (fk_produto,fk_venda,pro_valor,pro_quant) VALUES (?,?,?,?)");
				
				
				st.setInt(1,listaModelItensVendidos.get(i).getProdutos());
				st.setInt(2,listaModelItensVendidos.get(i).getVenda());
				st.setDouble(3,listaModelItensVendidos.get(i).getProValor());
				st.setInt(4,listaModelItensVendidos.get(i) .getProQuant());
						
				
				st.executeUpdate();
				
				
			}
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
