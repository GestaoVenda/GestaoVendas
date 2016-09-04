package br.com.wansan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Razão Social não pode estar vazio")
	@Column(name = "razao_social")
	private String nome;
	
	@NotNull(message = "CNPJ não pode estar vazio")
	private Long cnpj;
	
	@NotNull(message = "Inscrição Estadual não pode estar vazio")
	private Long inscricao_estadual;
	
	@NotNull(message = "Inscrição Manual não pode estar vazio")
	private Long inscricao_municipal;
	
	@NotEmpty(message = "Site não pode estar vazio")
	private String site;
	
	@NotEmpty(message = "Email não pode estar vazio")
	@Email
	private String email;
	
	@NotNull(message = "Telefone não pode estar vazio")
	private Long telefone;
	
	@NotEmpty(message = "Fax não pode estar vazio")
	private String fax;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String razao_social) {
		this.nome = razao_social;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Long getInscricao_estadual() {
		return inscricao_estadual;
	}

	public void setInscricao_estadual(Long inscricao_estadual) {
		this.inscricao_estadual = inscricao_estadual;
	}

	public Long getInscricao_municipal() {
		return inscricao_municipal;
	}

	public void setInscricao_municipal(Long inscricao_municipal) {
		this.inscricao_municipal = inscricao_municipal;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
}
