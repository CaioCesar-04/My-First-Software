package model.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.entidades.ModelUsuario;

public class QueryUsuario {
	
	public static ModelUsuario retornaUsuario(Connection conecta,int uId) {
		ModelUsuario modelUsuario = new ModelUsuario();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conecta.createStatement();
			rs = st.executeQuery("SELECT username, senha, nome, id FROM usuario WHERE id ='"+ uId +"';"); 
			while(rs.next()) {
				modelUsuario = new ModelUsuario(); 
				modelUsuario.setUsername(rs.getString(1));
				modelUsuario.setSenha(rs.getString(2));
				modelUsuario.setNome(rs.getString(3));
				modelUsuario.setId(rs.getInt(4));	
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
		return modelUsuario; 
	}
	public static ArrayList<ModelUsuario> retornaListaUsuarios(Connection conecta){
		ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
		ModelUsuario modelUsuario= new ModelUsuario();
		Statement st = null;
		ResultSet rs = null;
		try {
			st= conecta.createStatement();
			rs = st.executeQuery("SELECT username,senha,nome,id FROM usuario;"); 
			while(rs.next()) {
				modelUsuario= new ModelUsuario(); 
				modelUsuario.setUsername(rs.getString(1));
				modelUsuario.setSenha(rs.getString(2));
				modelUsuario.setNome(rs.getString(3));
				modelUsuario.setId(rs.getInt(4));
				
				listaModelUsuarios.add(modelUsuario);
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
		return listaModelUsuarios;
	}
	
	public static void consultaUsuario (Connection conecta) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conecta.createStatement();
			rs = st.executeQuery("Select * from usuario");
					while (rs.next()) {
						System.out.println(rs.getString("Username") + rs.getString("Senha")+ rs.getInt("Id"));
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
	public static void insereUsuario(Connection conecta,ModelUsuario modelUsuario) {
		PreparedStatement st = null;
	try {
		st=conecta.prepareStatement("INSERT INTO usuario" + "(username, senha,nome)" + "VALUES" + "(?,?,?)");
		
		st.setString(1, modelUsuario.getUsername());
		st.setString(2,modelUsuario.getSenha());
		st.setString(3,modelUsuario.getNome());
		st.executeUpdate();
		
		System.out.println("\n O vendedor foi inserido");
	}
	catch(SQLException e ) {
		
		e.printStackTrace();
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
	public static void alteraUsuario(Connection conecta,ModelUsuario modelUsuario) {
		
		Statement st =null;
		
		try {
			st = conecta.createStatement();
			st.executeUpdate("UPDATE usuario SET senha = '"+ modelUsuario.getSenha() +"', username = '"+modelUsuario.getUsername()+"', nome ='"+modelUsuario.getNome()+"' WHERE id = '"+modelUsuario.getId()+"'");
			
			

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void excluirUsuario(Connection conecta, int uId) {
		Statement st =null;
		
		try {
			st=conecta.createStatement();
			st.executeUpdate("DELETE FROM usuario WHERE id = '"+ uId +"'");
			JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso","Deletado",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível deletar o usuário.","Erro",JOptionPane.ERROR_MESSAGE);
		}finally {
			
			try {
				st.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public static boolean validaUsuario(Connection conecta,ModelUsuario modelUsuario) {
		
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conecta.createStatement();
			rs = st.executeQuery("SELECT username, senha, nome, id FROM usuario WHERE username ='"+ modelUsuario.getUsername() +"' AND senha = '"+ modelUsuario.getSenha()+"';"); 
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
		}catch(Exception e){
			e.printStackTrace();
			return false;
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
		
	}

}
