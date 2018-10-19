package com.usjt.sce;

import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;

public class ObtemUsuario {
	
	public static Usuario comDadosValidos() {
		
		Usuario usuario = new Usuario();
		usuario.setRa("222222");
		usuario.setNome("Jose Silva");  
		
		return usuario;
	}
	
	public static Usuario comRAInvalido_branco() {
			
		Usuario usuario = new Usuario();
		
		usuario.setRa("");
		usuario.setNome("Jose Silva"); 
		
		return usuario;
	}
	
	public static Usuario comRAInvalido_Nulo() {
		
		Usuario usuario = new Usuario();
		
		usuario.setRa(null);
		usuario.setNome("Jose Silva"); 
		
		return usuario;
	}
	
	public static Usuario comNomeInvalido_branco() {
		
		Usuario usuario = new Usuario();
		usuario.setRa("222222");
		usuario.setNome(""); 
		
		return usuario;
	}
	
	public static Usuario comNomeInvalido_nulo() {
		
		Usuario usuario = new Usuario();
		usuario.setRa("222222");
		usuario.setNome(null); 
		
		return usuario;
	}	
}
