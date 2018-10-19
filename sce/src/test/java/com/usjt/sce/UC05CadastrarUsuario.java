package com.usjt.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.usjt.sce.model.Livro;
import com.usjt.sce.model.Usuario;

public class UC05CadastrarUsuario {

	@Test
	public void CT01CadastrarUsuarioComDadosValidos() {
		
		try 
		{
			// cenario
			Usuario umUsuario;
			// acao 
			umUsuario = ObtemUsuario.comDadosValidos();
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			fail("nao deve falhar"); 
		}
	}
	
	@Test
	public void CT02CadastrarUsuarioComRABranco() {
		
		try 
		{
			// cenario
			Usuario umUsuario;
			
			// acao
			umUsuario = ObtemUsuario.comRAInvalido_branco();
			
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("RA invalido",e.getMessage());
		}
	}
	
	@Test
	public void CT03CadastrarUsuarioComRANulo() {
		
		try 
		{
			// cenario
			Usuario umUsuario;
			
			// acao
			umUsuario = ObtemUsuario.comRAInvalido_Nulo();
			
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("RA invalido",e.getMessage());
		}
	}
	
	@Test
	public void CT04CadastrarUsuarioComDadosValidos() {
		
		// Cenário
		Usuario usuario = new Usuario();
		
		usuario.setRa("222222");
		usuario.setNome("Jose Silva"); 
		
		// verificacao
		assertEquals("222222", usuario.getRa());		
	}
	
	@Test
	public void CT05CadastrarUsuarioComDadosValidos() {
		
		// cenario
		Usuario usuario = new Usuario();
					
		// acao
		usuario = ObtemUsuario.comDadosValidos();
					
		// verificacao
		assertEquals("Jose Silva", usuario.getNome());
	}
	
	@Test
	public void CT06CadastrarUsuarioComNomeBranco() {
		
		try 
		{
			// cenario
			Usuario umUsuario;
			
			// acao
			umUsuario = ObtemUsuario.comNomeInvalido_branco();
			
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Nome invalido",e.getMessage());
		}
	}
	
	@Test
	public void CT07CadastrarUsuarioComNomeNulo() {
		
		try 
		{
			// cenario
			Usuario umUsuario;
			
			// acao
			umUsuario = ObtemUsuario.comNomeInvalido_nulo();
			
		} 
		catch (RuntimeException e) 
		{
			// verificacao
			assertEquals("Nome invalido",e.getMessage());
		}
	}
}
