package com.elibrelato.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "empresa") // se não especificar o nome da tabela do banco, por default será utilizada o nome da classe.
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 4862991749577621407L;
	
	private Long id;
	private String razaoSocial;
	private String cnpj;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private List<Funcionario> funcionarios;
	
	public Empresa() {
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "razao_social", nullable = false) 
	// Se não especificar o nome da coluna no banco de dados, por default será utilizado o nome da variável. No nosso caso razaoSocial
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name = "cnpj", nullable = false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "data_atualizacao", nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @OneToMany mapeia os funcionarios pelo campo "empresa" da entidade funcionario.
	// O parâmetro fetch é muito importante pois informa como será executado a query "select no banco".
	// Para fetch = FetchType.Lazy, ao executar getEmpresa(), será retornado apenas os dados da empresa (sem a lista de funcionarios).
	// Para fetch = FetchType.EAGER, ao executar getEmpresa(), também será executado o "select" dos funcionarios.
	// O parâmetro cascade também é muito importante. Ao definir cascade = CascadeType.ALL significa que se deletarmos uma empresa,
	// automaticamente todos os funcionarios dessa empresa também serão deletados.
	// Para não remover os funcionarios, não devemos definir o parâmetro cascade.
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@PreUpdate
	// update é quando estamos atualizando um objeto.
	// Sempre que atualizar os dados de uma empresa, a "dataAtualizacao" será atualizada automaticamente.
    public void preUpdate() {
        dataAtualizacao = new Date();
    }
     
    @PrePersist
    // persist é quando estamos inserindo um objeto pela primeira vez.
    // Sempre que inserir uma nova empresa, os campos "dataCriacao" e "dataAtualizacao" serão preenchidos automaticamente.
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	

}
