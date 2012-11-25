package br.edu.catolica.MOP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="fisico")
@PrimaryKeyJoinColumn(name="idcliente")

public class Fisico extends Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1985532296831573225L;
	
	@Column(name="cpf")
	private String cpf;
	@Column(name="rg")
	private String rg;
	@Column(name="estado_civil")
	private String estado_civil;
	@Column(name="nascimento")
	private Date nascimento;
	@OneToOne
	@JoinColumn(name ="genero_idgenero")
	private Genero genero;
	
	public Fisico (){
		
	}

	public Fisico(String cpf,String rg,String estado_civil, Date nasciento,Genero genero,Integer idcliente,String nome,String endereco,String email,Cidade cidade){
		super(idcliente, nome, endereco, email, cidade);
		this.cpf= cpf;
		this.rg= rg;
		this.estado_civil= estado_civil;
		this.nascimento = nasciento;
		this.genero= genero;
	
}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((estado_civil == null) ? 0 : estado_civil.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result
				+ ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		Fisico other = (Fisico) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (estado_civil == null) {
			if (other.estado_civil != null)
				return false;
		} else if (!estado_civil.equals(other.estado_civil))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
	
}