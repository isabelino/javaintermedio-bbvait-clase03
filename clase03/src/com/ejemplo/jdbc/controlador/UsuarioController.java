package com.ejemplo.jdbc.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ejemplo.jdbc.Conexion;
import com.ejemplo.jdbc.modelo.Usuario;

public class UsuarioController {
	
	
	public void insertar(Usuario usuario){
		String sql = "INSERT INTO usuarios (username,password,fullname,email) VALUES(?,?,?,?)";
		
		try {
			PreparedStatement statement = Conexion.conectar().prepareStatement(sql);
			statement.setString(1, usuario.getUsername());
			statement.setString(2, usuario.getPassword());
			statement.setString(3, usuario.getFullname());
			statement.setString(4, usuario.getEmail());
			//comprobar el insert
			int rowsInsertd = statement.executeUpdate();
			if(rowsInsertd >0 ) {
				System.out.println("Se insertó un nuevo usuario con éxito");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void listarUsuarios() {
		String sql ="SELECT * FROM usuarios";
		
		try {
			
			Statement statement = Conexion.conectar().createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int cont= 0;
			
			while( result.next() ) {
				String username = result.getString(2);
				String password = result.getString(3);
				String fullname = result.getString(4);
				String email = result.getString(5);
				
				String output = "usuario #%d: %s - %s - %s - %s";
				
				System.out.println( String.format(output,++cont, username,password,fullname,email));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void actualizar(Usuario usuario) {
		
		String sql= "UPDATE usuarios SET username=?,password=?,fullname=?,email=? WHERE id=?";
		
		try {
			PreparedStatement statement = Conexion.conectar().prepareStatement(sql);
			statement.setString(1, usuario.getUsername());
			statement.setString(2, usuario.getPassword());
			statement.setString(3, usuario.getFullname());
			statement.setString(4, usuario.getEmail());
			statement.setInt(5, usuario.getId());
			//comprobar el update
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated > 0 ) {
				System.out.println("Se ha actualizado con éxito");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void eliminar(int id) {
		String sql="DELETE FROM usuarios WHERE id=?";
		
		try {
			
			PreparedStatement statement = Conexion.conectar().prepareStatement(sql);
			statement.setInt(1, id);
			
			int rowsDeleted = statement.executeUpdate();
			if(rowsDeleted > 0) {
				System.out.println("Usuario eliminado exitosamente!");
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	

}
