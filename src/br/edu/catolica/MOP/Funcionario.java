package br.edu.catolica.MOP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@PrimaryKeyJoinColumn(name="idcliente")
public class Funcionario extends Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 386963472153470986L;
	@Column(name = "matricula")
	private int matricula;
	@Column(name = "admissao")
	private Date admissao;
	@Column(name = "salario")
	private float salario;
	@Column(name = "cargo")
	private String Cargo;

	public Funcionario() {

	}

	public Funcionario(int matricula,Date admissao,float salario,String cargo ,Integer idcliente,String nome,String endereco,String email,Cidade cidade){
		super(idcliente, nome, endereco, email, cidade);
		
		this.matricula = matricula;
		this.admissao = admissao;
		this.salario = salario;
		this.Cargo = cargo;
		
	}

	

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Date getAdmissao() {
		return admissao;
	}

	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Cargo == null) ? 0 : Cargo.hashCode());
		result = prime * result
				+ ((admissao == null) ? 0 : admissao.hashCode());
		result = prime * result + matricula;
		result = prime * result + Float.floatToIntBits(salario);
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
		Funcionario other = (Funcionario) obj;
		if (Cargo == null) {
			if (other.Cargo != null)
				return false;
		} else if (!Cargo.equals(other.Cargo))
			return false;
		if (admissao == null) {
			if (other.admissao != null)
				return false;
		} else if (!admissao.equals(other.admissao))
			return false;
		if (matricula != other.matricula)
			return false;
		if (Float.floatToIntBits(salario) != Float
				.floatToIntBits(other.salario))
			return false;
		return true;
	}

	
	







}