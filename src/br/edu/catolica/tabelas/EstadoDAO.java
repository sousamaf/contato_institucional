package br.edu.catolica.tabelas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.EstadoBean;
import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Estado;
import br.edu.catolica.conexao.HibernateUtil;


public class EstadoDAO {
	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Estado estado)

	{



		try{

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(estado);

			transacao.commit();

			//sessao.close();

		} catch(HibernateException e) {
			sessao.beginTransaction().rollback();
			System.out.println("Nao foi possivel inserir o contato. Erro" + e.getMessage());


		}
		finally{
			sessao.close();
		}

	}
	public void remove(Estado estado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(estado);
		t.commit();
		}
	public void update(Estado estado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(estado);
		t.commit();
		}
	public List list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Estado").list();
		t.commit();
		return lista;
		}

	public static void main(String [] args){

		
//		Estado estado = new Estado();
	//	estado.setIdestado("AM");
//		estado.setEstado("Amazonas");
		
		EstadoDAO dao = new EstadoDAO();
	//	dao.salvar(estado);
		List<Estado> estados= dao.list();
		  
		  for(Estado est: estados){
		  System.out.println(est.getEstado());
		 
				

		  
		   // CidadeDAO dao  = new CidadeDAO();
		   // cidades  = dao.buscartudo();
		   // for(Cidade cid: cidades){
		     //   System.out.println(cid.getNome_cidade());
		    }






	}



}