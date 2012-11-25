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
@Entity
@Table(name="redes_sociais")



public class Redes_Sociais  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4735010330843998147L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idredes_sociais")
	private Integer idredes_socias;
	@Column(name="conta")
	private String conta;
	@Column(name="tipo")
	private String tipo;
	@ManyToOne
	@JoinColumn(name="cliente_idcliente")
	private Cliente cliente;
	
	
	
	public Redes_Sociais (){
		
	}



	public Redes_Sociais(Integer idredes_socias, String conta, String tipo,
			Cliente cliente) {
		this.idredes_socias = idredes_socias;
		this.conta = conta;
		this.tipo = tipo;
		this.cliente = cliente;
	}



	public Integer getIdredes_socias() {
		return idredes_socias;
	}



	public void setIdredes_socias(Integer idredes_socias) {
		this.idredes_socias = idredes_socias;
	}



	public String getConta() {
		return conta;
	}



	public void setConta(String conta) {
		this.conta = conta;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result
				+ ((idredes_socias == null) ? 0 : idredes_socias.hashCode());
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
		Redes_Sociais other = (Redes_Sociais) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (idredes_socias == null) {
			if (other.idredes_socias != null)
				return false;
		} else if (!idredes_socias.equals(other.idredes_socias))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
	

}
