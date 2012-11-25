package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Cliente;
import br.edu.catolica.MOP.Juridico;
import br.edu.catolica.MOP.Redes_Sociais;
import br.edu.catolica.conexao.HibernateUtil;

public class Redes_sociasDao {
	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Redes_Sociais redes_Sociais)

	{



		try{

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(redes_Sociais);

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
	public void remove(Redes_Sociais redes_sociais) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(redes_sociais);
		t.commit();
		}
	public void update(Redes_Sociais redes_sociais) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(redes_sociais);
		t.commit();
		}
	public List<Redes_Sociais> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from redes_sociais").list();
		t.commit();
		return lista;
		}

	/*public static void main(String [] args){
		
		Cliente cliente = new Cliente();
		cliente.setIdcliente(1);
		
		Redes_Sociais rs = new Redes_Sociais();
		rs.setCliente(cliente);
		rs.setConta("conta");
		rs.setTipo("tipo");
		
		Redes_sociasDao dao = new Redes_sociasDao();
		dao.salvar(rs);
}*/
}