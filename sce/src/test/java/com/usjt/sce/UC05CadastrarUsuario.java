package com.usjt.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;

public class UC05CadastrarUsuario {

	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		try {
			// cenario
			Usuario umAluno = new Usuario();
			// acao
			umAluno.setRa("121212");
			umAluno.setNome("Jose da Silva");
		} catch (RuntimeException e) {
			// verificacao
			fail("nao deve falhar");
		}
	}
}
