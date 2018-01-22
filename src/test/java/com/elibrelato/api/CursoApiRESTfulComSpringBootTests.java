package com.elibrelato.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test") // define qual o profile será carregado para o teste. No nosso caso, será o application-test.properties
public class CursoApiRESTfulComSpringBootTests {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCarregarContextoDeTeste() {
		assertEquals(100, qtdPorPagina); // faz a verificação para validar se o valor da variavel qtdPorPagina equivale a 100.
	}

}
