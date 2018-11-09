package com.usjt.sce;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
	
	public static Emprestimo comDataDeDevolucaoVencida() {
		
		Livro livro = ObtemLivro.comDadosValidos();
		
		Usuario aluno = ObtemUsuario.comDadosValidos();
		
		ServicoEmprestimo servico = new ServicoEmprestimo();
		
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		
		DateTime dataAtual = new DateTime();
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		
		umEmprestimo.setDataEmprestimo(dataAtual.minusDays(12).toString(fmt));
		
		umEmprestimo.setDataDevolucao(dataAtual.minusDays(4).toString(fmt));
		
		return umEmprestimo;
	}
	
	public static Emprestimo comDataDeDevolucaoIgualEmprestimo() {
		
		Livro livro = ObtemLivro.comDadosValidos();
		
		Usuario aluno = ObtemUsuario.comDadosValidos();
		
		ServicoEmprestimo servico = new ServicoEmprestimo();
		
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		
		DateTime dataAtual = new DateTime();
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		
		//umEmprestimo.setDataEmprestimo(dataAtual.toString(fmt));
		
		umEmprestimo.setDataDevolucao(dataAtual.toString(fmt));
		
		return umEmprestimo;
	}
	
	public static Emprestimo comDataDeDevolucaoUmDiaAposEmprestimo() {
		
		Livro livro = ObtemLivro.comDadosValidos();
		
		Usuario aluno = ObtemUsuario.comDadosValidos();
		
		ServicoEmprestimo servico = new ServicoEmprestimo();
		
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		
		DateTime dataAtual = new DateTime();
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		
		umEmprestimo.setDataEmprestimo(dataAtual.minusDays(2).toString(fmt));
		
		umEmprestimo.setDataDevolucao(dataAtual.minusDays(1).toString(fmt));
		
		return umEmprestimo;
	}
	public static Emprestimo comDataDeDevolucaoUmDiaAntesDaDevolucaoLimite() {
		
		Livro livro = ObtemLivro.comDadosValidos();
		
		Usuario aluno = ObtemUsuario.comDadosValidos();
		
		ServicoEmprestimo servico = new ServicoEmprestimo();
		
		Emprestimo umEmprestimo = servico.empresta(livro, aluno);
		
		DateTime dataAtual = new DateTime();
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		
		umEmprestimo.setDataEmprestimo(dataAtual.minusDays(8).toString(fmt));
		
		umEmprestimo.setDataDevolucao(dataAtual.minusDays(1).toString(fmt));
		
		return umEmprestimo;
	}
	
}