package br.edu.catolica.MOP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="genero")
public class Genero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -945979819556250258L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idgenero")
	private Integer idgenero;
	@Column(name="sexo")
	private String sexo;
	public Integer getIdgenero() {
		return idgenero;
	}
	public void setIdgenero(Integer idgenero) {
		this.idgenero = idgenero;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idgenero == null) ? 0 : idgenero.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Genero other = (Genero) obj;
		if (idgenero == null) {
			if (other.idgenero != null)
				return false;
		} else if (!idgenero.equals(other.idgenero))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}
	
	
}
