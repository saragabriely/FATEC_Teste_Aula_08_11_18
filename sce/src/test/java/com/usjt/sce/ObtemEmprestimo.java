package com.usjt.sce;

import com.usjt.sce.model.Emprestimo;
import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;
import com.usjt.sce.servico.ServicoEmprestimo;

public class ObtemEmprestimo 
{
	public static Emprestimo comDadosValidos() 
	{
		
		Livro livro = ObtemLivro.comDadosValidos();
		Usuario aluno = ObtemUsuario.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		
		return servico.empresta(livro, aluno);
	}
		
	
	public static Emprestimo comLivroNulo() 
	{
		Livro   livro = null;
		Usuario aluno = new Usuario();
		
		aluno = ObtemUsuario.comDadosValidos();
			
		Emprestimo emprestimo = new Emprestimo();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		
		return servico.empresta(livro, aluno);
	}
	
	public static Emprestimo comUsuarioNulo() 
	{
		Livro   livro =  ObtemLivro.comDadosValidos();
		Usuario aluno = null;
		 
		ServicoEmprestimo servico = new ServicoEmprestimo();
		
		return servico.empresta(livro, aluno);
	}
}