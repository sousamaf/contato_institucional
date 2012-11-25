package br.edu.catolica.MOP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="juridico")
@PrimaryKeyJoinColumn(name="idcliente")

public class Juridico extends Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5513996723019615692L;
	
	@Column(name="razao")
	private String razao;
	@Column(name="cnpj")
	private String cnpj;
	@Column(name="e_estadual")
	private String e_estadual;
	@Column(name="descricao")
	private String descricao;
	
	
	public Juridico (){
		
	}
	
	public Juridico (String razao,String cnpj,String e_estadual,String descricao,Integer idcliente,String nome,String endereco,String email,Cidade cidade){
		super(idcliente, nome, endereco, email, cidade);
		this.razao= razao;
		this.cnpj= cnpj;
		this.e_estadual = e_estadual;
		this.descricao = descricao;
}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getE_estadual() {
		return e_estadual;
	}

	public void setE_estadual(String e_estadual) {
		this.e_estadual = e_estadual;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((e_estadual == null) ? 0 : e_estadual.hashCode());
		result = prime * result + ((razao == null) ? 0 : razao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juridico other = (Juridico) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (e_estadual == null) {
			if (other.e_estadual != null)
				return false;
		} else if (!e_estadual.equals(other.e_estadual))
			return false;
		if (razao == null) {
			if (other.razao != null)
				return false;
		} else if (!razao.equals(other.razao))
			return false;
		return true;
	}
	
}