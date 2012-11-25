package br.edu.catolica.MOP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@MappedSuperclass
@Entity
@Table(name="cliente")
@Inheritance(strategy=InheritanceType.JOINED)
 //classe pai

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7428930206206369483L;

	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "idcliente")
	private Integer idcliente;
	@Column(name="nome")
	private String nome;
	@Column(name="endereco")
	private String endereco;
	@Column(name="email")
	private String email;
	@ManyToOne
	@JoinColumn(name="cidade_idcidade")
	private Cidade cidade;

	public Cliente() {

	}

	

	public Cliente(Integer idcliente, String nome, String endereco,
			String email, Cidade cidade) {
		super();
		this.idcliente = idcliente;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.cidade = cidade;
	}



	public Integer getIdcliente() {
		return idcliente;
	}



	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Cidade getCidade() {
		return cidade;
	}



	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((idcliente == null) ? 0 : idcliente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (idcliente == null) {
			if (other.idcliente != null)
				return false;
		} else if (!idcliente.equals(other.idcliente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

}
