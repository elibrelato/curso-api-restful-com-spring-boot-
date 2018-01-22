package com.elibrelato.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elibrelato.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> { // Empresa é a entidade e Lond a chave primária

	Empresa findByCnpj(String cnpj);
	
	/*
	@Query("SELECT t.title FROM Todo t where t.id = :id") 
    String findTitleById(@Param("id") Long id);
     
    @Query("SELECT t.title FROM Todo t where t.id = :id") 
    Optional<String> findTitleById(@Param("id") Long id);
 
    Todo findById(Long id);
     
    Optional<Todo> findById(Long id);
	 */

}
