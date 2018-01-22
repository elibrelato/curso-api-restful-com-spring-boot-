package com.elibrelato.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.elibrelato.api.entities.Empresa;
import com.elibrelato.api.repository.EmpresaRepository;

/*

import com.elibrelato.meuprimeiroprojeto.utils.SenhaUtils;
*/

@SpringBootApplication
public class CursoApiRESTfulComSpringBoot {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;  // carrega do campo paginacao.qtd_por_pagina do arquivo application.properties e attribui a variavel qtdPorPagina
	
	public static void main(String[] args) {
		SpringApplication.run(CursoApiRESTfulComSpringBoot.class, args);
		// System.out.println("Meu primeiro projeto Spring Boot...");
	}
	

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
/*
			// teste de parametros
			System.out.println();
			System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);
			System.out.println();
			
			// teste de senha
			String senha = "12345";
			String senhaEncoded = SenhaUtils.gerarBCrypt(senha);
			System.out.println("SenhaEncoded: " + senhaEncoded);
			
			senhaEncoded = SenhaUtils.gerarBCrypt(senha);
			System.out.println("SenhaEncoded Novamente: " + senhaEncoded);			
			System.out.println("Senha Valida: " + SenhaUtils.senhaValida(senha, senhaEncoded));
			System.out.println();
			
*/
			
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Kazale IT");
			empresa.setCnpj("74645215000104");
			
			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Empresa empresaDb = empresaRepository.findOne(1L);
			System.out.println("Empresa por ID: " + empresaDb);
			
			empresaDb.setRazaoSocial("Kazale IT Web");
			this.empresaRepository.save(empresaDb);

			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			
			this.empresaRepository.delete(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());

			
		};
	}
}
