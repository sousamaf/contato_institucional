package br.edu.catolica;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Estado;
import br.edu.catolica.tabelas.CidadeDAO;
import br.edu.catolica.tabelas.EstadoDAO;


@ManagedBean (name="controllerCidade")
@SessionScoped
public class CidadeRN {
	private Estado e = new Estado();
	private List<Cidade> cidades ;
	public Estado getE() {
		return e;
	}

	
	public void setE(Estado e) {
		this.e = e;
	}


	private EstadoDAO daoE = new EstadoDAO();
	private Cidade cidade;
	private CidadeDAO cidadedao;
	private Estado estado;
	private List<Estado> estados = daoE.list();
	public CidadeRN() {
		estado = new Estado();
		cidade = new Cidade();
		cidadedao= new  CidadeDAO();
	}
	
	
	public String Inserir (){
		
		//if(cidade ==null){
			//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Erro ao inserir cidade",""));
		//}else{
			cidadedao.salvar(cidade);
	//	}
		
		return "";
		
	}

	

	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
	}

	public EstadoDAO getDaoE() {
		return daoE;
	}

	public void setDaoE(EstadoDAO daoE) {
		this.daoE = daoE;
	}


	public List<Estado> getEstados() {
		return estados;
	}


	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}


	public List<Cidade> getCidades() {
		return cidades;
	}


	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	
	

	
}