package br.edu.catolica;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.catolica.MOP.Estado;
import br.edu.catolica.tabelas.EstadoDAO;

@ManagedBean(name="estadoBean")
@RequestScoped

public class EstadoBean {
	
	private String idestado;
	private Estado estado;
	
	public EstadoBean(){
		
	}
	
	 public void salvar() {
	        EstadoDAO dao = new EstadoDAO();
	        dao.salvar(estado);
	    }

	    //public void excluir() {
	      //  EstadoDAO dao = new EstadoDAO();
	    //    dao.excluir(estado);
	    //}
}
