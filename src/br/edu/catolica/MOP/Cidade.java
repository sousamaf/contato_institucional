package br.edu.catolica.MOP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="cidade")

public class Cidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -67179907569370524L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idcidade")
	private Integer idcidade;
	@Column(name = "cidade")
	private String cidade;
	@ManyToOne
	@JoinColumn(name = "estado_idestado")
	private Estado estado;
	
	public Cidade(){
		
	}
	public Cidade(Integer idcidade, String cidade, Estado estado) {
		this.idcidade = idcidade;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Integer getIdcidade() {
		return idcidade;
	}
	public void setIdcidade(Integer idcidade) {
		this.idcidade = idcidade;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((idcidade == null) ? 0 : idcidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idcidade == null) {
			if (other.idcidade != null)
				return false;
		} else if (!idcidade.equals(other.idcidade))
			return false;
		return true;
	}	
	
	
	

}
