package com.ejemplo.jdbc;

import com.ejemplo.jdbc.controlador.UsuarioController;
import com.ejemplo.jdbc.modelo.Usuario;

public class Principal {

	public static void main(String[] args) {
		//probando conexion
		//Conexion.conectar();
		
		//probar el insert
		UsuarioController usuarioControl = new UsuarioController();
		/*
		Usuario usuarioInsert= new Usuario("rlopez","admin123","rolando lopez","rlopez@email.com");
		Usuario usuarioInsert2= new Usuario("msuarez","admin123","Maria Suarez","msuarez@email.com");
		Usuario usuarioInsert3= new Usuario("jperez","admin123","Jose Perez","jperez@email.com");
		
		usuarioControl.insertar(usuarioInsert3);*/
		//listar usuarios
		usuarioControl.listarUsuarios();
		//actualizar usuario
		//Usuario usuarioInsert= new Usuario("lcarlos","admin123","carlos lopez","clopez@email.com");
		/*usuarioInsert.setId(1);
		
		usuarioControl.actualizar(usuarioInsert);
		*/
	
		
		usuarioControl.eliminar(3);
		
		usuarioControl.listarUsuarios();
	}

}
