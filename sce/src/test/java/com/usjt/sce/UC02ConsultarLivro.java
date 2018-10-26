package com.usjt.sce;

import static org.junit.Assert.*;
import org.junit.Test;

import com.usjt.sce.model.DAOFactory;
import com.usjt.sce.model.ILivroDAO;
import com.usjt.sce.model.Livro;

public class UC02ConsultarLivro {
	
	@Test
	public void CT01CadastrarLivro_com_sucesso() 
	{
		// cenario
		Livro umLivro = ObtemLivro.comDadosValidos(); // captura objeto com dados validos
		Livro resultadoObtido = null;				  // objeto nulo
		
		DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		ILivroDAO livroDAO = mySQLFactory.getLivroDAO();
		
		// Acao
		livroDAO.adiciona(umLivro); 
		resultadoObtido = livroDAO.consulta(umLivro.getIsbn());
		
		// verificacao
		assertTrue(resultadoObtido.equals(umLivro)); // COMPARACAO
		
		livroDAO.exclui(umLivro.getIsbn());
	}
}
