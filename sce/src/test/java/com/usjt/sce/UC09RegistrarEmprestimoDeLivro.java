package com.usjt.sce;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import com.usjt.sce.model.Emprestimo;
import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;
import com.usjt.sce.servico.ServicoEmprestimo;

public class UC09RegistrarEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;

	@Test
	public void CT01RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");

		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");

		servico = new ServicoEmprestimo();

		// acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);

		// verificação
		assertNotNull(resultadoEsperado);
	}

	@Test
	public void CT02RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		Emprestimo emprestimo = null;
		// acao
		emprestimo = ObtemEmprestimo.comDadosValidos();
		// verificação
		assertNotNull(emprestimo);
	}

	
	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		ServicoEmprestimo servico = null;
		// acao
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}

	@Test
	public void CT03RegistraServicoDeLivro_nulo() 
	{		
		try 
		{
			Emprestimo emprestimo = null;
			// acao
			emprestimo = ObtemEmprestimo.comLivroNulo();
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage()); 
		}
	}
	
	@Test
	public void CT04RegistraServicoDeLivro_UsuarioNulo() 
	{		
		try 
		{
			Emprestimo emprestimo = null;
			// acao
			emprestimo = ObtemEmprestimo.comUsuarioNulo();
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage()); 
		}
	}
	
	@Test
	public void CT05RegistraEmprestimoDeLivro_LivroNulo() 
	{		
		Livro livro = null;
		Emprestimo emprestimo = new Emprestimo();

		try 
		{
			// acao
			emprestimo.setLivro(livro);
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Dados invalidos.", e.getMessage()); 
		}
	}
	
	@Test
	public void CT06RegistraEmprestimoDeLivro_UsuarioNulo() 
	{		
		Usuario aluno = null;
		Emprestimo emprestimo = new Emprestimo();

		try 
		{
			// acao
			emprestimo.setUsuario(aluno);
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Dados invalidos.", e.getMessage()); 
		}
	}
	
	@Test
	public void CT07Emprestimo_getLivro() 
	{		

		Emprestimo emprestimo = new Emprestimo();
		Livro livro = new Livro();
		try 
		{
			// acao
			livro = emprestimo.getLivro();
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage()); 
		}
	}
	
	@Test
	public void CT08Emprestimo_getUsuario() 
	{		
		Emprestimo emprestimo = new Emprestimo();
		Usuario usuario = new Usuario();

		try 
		{
			// acao
			usuario = emprestimo.getUsuario();
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Dados inválidos.", e.getMessage()); 
		}
	}
	
	@Test
	public void CT09UC01FB_registra_emprestimo_com_data_invalida() {
		// cenario
		Emprestimo emprestimo = new Emprestimo();
		
		DateTime dataAtual = new DateTime();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		
		
		try {
			// acao
			emprestimo.setDataEmprestimo(dataAtual.toString(fmt));
			
		}
		catch (RuntimeException e) {

			// verificacao
			assertEquals("Data invalida.", e.getMessage()); 
			
		}
	}
	
	/**
	* Objetivo - verificar o comportamento do metodo ehDomigo() para uma data com formato
	* valido dia invalido (domingo).
	*/
	@Test
	public void CT06se_data_devolucao_for_domingo_retorna_true(){
		//cenario
		String data = "2018/09/02"; //domingo
		//acao
		Emprestimo umEmprestimo = new Emprestimo();
		//verificacao
		assertTrue(umEmprestimo.ehDomingo(data));
	}
	
	@Test
	public void CT07_quando_entrega_atrasado_quant_dias_negativo(){
		
		//cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
		ServicoEmprestimo servico= new ServicoEmprestimo();
		
		//acao
		int quantDias = servico.devolucao(umEmprestimo);
		//verificacao
		assertTrue (quantDias < 0); //quant de dias entre a data de emprestimo e a de devolucao
	}
	
	
	@Test
	public void CT10_data_devolucao_em_dia_da_semana_valido(){
		//cenario
		String data = "2018/11/08"; //quinta
		//acao
		Emprestimo umEmprestimo = new Emprestimo();
		//verificacao
		assertFalse(umEmprestimo.ehDomingo(data));
	}
	
	@Test
	public void CT10_data_devolucao_formato_invalido(){
		//cenario
		String data = "1/maio/05";
		//acao
		Emprestimo umEmprestimo = new Emprestimo();
		//verificacao
		assertFalse(umEmprestimo.ehDomingo(data));
	}
	
	@Test
	public void CT11_quando_entrega_no_mesmo_dia(){
		
		//cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoIgualEmprestimo();
		ServicoEmprestimo servico= new ServicoEmprestimo();
		
		//acao
		int quantDias = servico.devolucao(umEmprestimo);
		//verificacao
		assertTrue (quantDias == 0); //quant de dias entre a data de emprestimo e a de devolucao
	}
	
	@Test
	public void CT12_quando_entrega_um_dia_apos_emprestimo(){
		
		//cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoUmDiaAposEmprestimo();
		ServicoEmprestimo servico= new ServicoEmprestimo();
		
		//acao
		int quantDias = servico.devolucao(umEmprestimo);
		//verificacao
		assertTrue (quantDias < 0); //quant de dias entre a data de emprestimo e a de devolucao
	}
	
	@Test
	public void CT12_quando_entrega_um_dia_antes_da_devolucao_limite(){
		
		//cenario
		Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoUmDiaAntesDaDevolucaoLimite();
		ServicoEmprestimo servico= new ServicoEmprestimo();
		
		//acao
		int quantDias = servico.devolucao(umEmprestimo);
		//verificacao
		assertTrue (quantDias < 0); //quant de dias entre a data de emprestimo e a de devolucao
	}

}