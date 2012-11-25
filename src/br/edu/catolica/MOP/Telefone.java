package br.edu.catolica.MOP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.catolica.ClienteRN;
@Entity
@Table(name="telefone")

public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7356621423475038075L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idtelefone")
	private Integer idtelefone;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "telefone")
	private String telefone;
	@ManyToOne
	@JoinColumn(name= "cliente_idcliente")
	private Cliente cliente;
	
	public Telefone(){
		
	}

	public Telefone(Integer idtelefone, String tipo, String telefone,
			Cliente cliente) {
		this.idtelefone = idtelefone;
		this.tipo = tipo;
		this.telefone = telefone;
		this.cliente = cliente;
	}

	public Integer getIdtelefone() {
		return idtelefone;
	}

	public void setIdtelefone(Integer idtelefone) {
		this.idtelefone = idtelefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((idtelefone == null) ? 0 : idtelefone.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Telefone other = (Telefone) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (idtelefone == null) {
			if (other.idtelefone != null)
				return false;
		} else if (!idtelefone.equals(other.idtelefone))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
	
	
	
}
