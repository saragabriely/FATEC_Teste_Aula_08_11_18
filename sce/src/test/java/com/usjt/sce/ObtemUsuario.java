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
}
