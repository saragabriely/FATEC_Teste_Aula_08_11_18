package com.usjt.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usjt.sce.model.DAOFactory;
import com.usjt.sce.model.ILivroDAO;
import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;

public class UC01CadastrarLivro {

	/**
	 * Objetivo: Verificar o comportamento com dados válidos
	 */

	@Test
	public void CT01CadastrarLivroComDadosValidos() {

		try {
			// cenario
			Livro umLivro = new Livro();

			// acao
			umLivro = ObtemLivro.comDadosValidos();

		} 
		catch (RuntimeException e) {

			// verificacao
			fail("nao deve falhar");
		}
	}

	/**
	 * Objetivo: Verificar o comportamento com ISBN em branco
	 */

	@Test
	public void CT02CadastrarLivroComISBNBranco() {

		try {
			// cenario
			Livro umLivro = new Livro();

			// acao
			umLivro = ObtemLivro.comISBNInvalido_branco();
		} 
		catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo: Verificar o comportamento com ISBN nulo
	 */

	@Test
	public void CT03CadastrarLivroComISBNNulo() {

		try {
			// cenario
			Livro umLivro = new Livro();

			// acao
			umLivro = ObtemLivro.comISBNInvalido_nulo();

		} 
		catch (RuntimeException e) {
			// verificacao
			assertEquals("ISBN invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo: Verificar o comportamento ao buscar o ISBN
	 */

	@Test
	public void CT04CadastrarLivroComDadosValidos() {

		// cenario
		Livro umLivro = new Livro();

		// acao
		umLivro.setIsbn("1111");
		umLivro.setTitulo("Engenharia de Software");
		umLivro.setAutor("Pressman");

		// verificacao
		assertEquals("1111", umLivro.getIsbn());
	}

	/**
	 * Objetivo: Verificar o comportamento ao buscar o titulo
	 */

	@Test
	public void CT05CadastrarLivroComDadosValidos() {

		// cenario
		Livro umLivro = new Livro();

		// acao
		umLivro = ObtemLivro.comDadosValidos();

		// verificacao
		assertEquals("Engenharia de Software", umLivro.getTitulo());

	}

	/**
	 * Objetivo: Verificar o comportamento com titulo em branco
	 */

	@Test
	public void CT06CadastrarLivroComTituloBranco() {
		
		try {
			// cenario
			Livro umLivro = new Livro();

			// acao
			umLivro = ObtemLivro.comTituloBranco();
		} 
		catch (RuntimeException e) {

			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}

	}

	/**
	 * Objetivo: Verificar o comportamento com titulo nulo
	 */

	@Test
	public void CT07CadastrarLivroComTituloNulo() {

		try {
			// cenario
			Livro umLivro = new Livro();

			// acao
			umLivro = ObtemLivro.comTituloNulo();

		} 
		catch (RuntimeException e) {
			// verificacao
			assertEquals("Titulo invalido", e.getMessage());
		}
	}

	/*
	 * Objetivo: Verificar o comportamento ao buscar titulo
	 */

	@Test
	public void CT08CadastrarLivroComTituloNulo() {

		// cenario
		Livro umLivro = new Livro();

		// acao
		umLivro = ObtemLivro.comDadosValidos();

		// verificacao
		assertEquals("Pressman", umLivro.getAutor());
	}

	/**
	 * Objetivo: Verificar o comportamento com autor em branco
	 */

	@Test
	public void CT09CadastrarLivroComAutorBranco() {

		try {
			// cenario
			Livro umLivro = new Livro();

			// acao
			umLivro = ObtemLivro.comAutorBranco();
		} 
		catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor invalido", e.getMessage());
		}
	}

	/**
	 * Objetivo: Verificar o comportamento com autor nulo
	 */

	@Test
	public void CT10CadastrarLivroComAutorNulo() {
		try {
			// cenario
			Livro umLivro = new Livro();

			// acao
			umLivro = ObtemLivro.comAutorNulo();
		} 
		catch (RuntimeException e) {
			// verificacao
			assertEquals("Autor invalido", e.getMessage());
		}
	}

	@Test
	public void CT11CadastrarLivro_com_sucesso() {
		
		// cenario
		Livro 	   umLivro 		= ObtemLivro.comDadosValidos();
		
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		ILivroDAO livroDAO 		= mySQLFactory.getLivroDAO();
		
		// acao
		int codigoRetorno = livroDAO.adiciona(umLivro);
		
		// verificacao
		assertEquals(1, codigoRetorno);
		
		livroDAO.exclui(umLivro.getIsbn());
	}
	
	@Test
	public void CT12CadastrarLivro_com_ISBN_duplicado() {
		
		// cenario
		Livro 	   umLivro 		= ObtemLivro.comDadosValidos();
					
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
					
		ILivroDAO livroDAO 		= mySQLFactory.getLivroDAO();
		
		try 
		{
			// acao
			livroDAO.adiciona(umLivro);
			livroDAO.adiciona(umLivro);
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '121212' for key 'PRIMARY'", 
					e.getMessage());
		}
		finally {
			livroDAO.exclui(umLivro.getIsbn());
		}
	}
}
