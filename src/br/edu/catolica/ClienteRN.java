package br.edu.catolica;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.oracle.jrockit.jfr.ValueDefinition;
import com.sun.security.ntlm.Client;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Cliente;
import br.edu.catolica.tabelas.CidadeDAO;
import br.edu.catolica.tabelas.ClienteDAO;



@ManagedBean(name="controllerCliente")
@RequestScoped

public class ClienteRN {
	
	private Cliente cliente;
	private  DataModel listaCliente;
    
	public ClienteRN(){
		cliente = new Cliente();
	}
	
	public DataModel getListarCliente() {
		List<Cliente> lista = new ClienteDAO().list();
		listaCliente = new ListDataModel(lista);
		return listaCliente;
		}
	public Cliente getCliente() {
		return cliente;
		}
		public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		}
             
		public String excluir(){
			Cliente cliente = (Cliente)(listaCliente.getRowData());
			ClienteDAO dao = new ClienteDAO();
			dao.remove(cliente);
			return "index";
			}
		public String Cadastrar(){
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			return "index";
			}
		public String alterar(){
			ClienteDAO dao = new ClienteDAO();
			dao.update(cliente);
			return "index";
			}
}