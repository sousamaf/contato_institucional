package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Estado;
import br.edu.catolica.conexao.HibernateUtil;

public class CidadeDAO {
	Session sessao = null;

	Transaction transacao = null;

	public void salvar(Cidade cidade)

	{

		try {

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(cidade);

			transacao.commit();

		} catch (HibernateException e) {
			sessao.beginTransaction().rollback();
			System.out.println("Nao foi possivel inserir o contato. Erro"
					+ e.getMessage());
		} finally {
			sessao.close();
		}

	}

	public void atualizar(Cidade cidade)

	{

		try {

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.update(cidade);

			transacao.commit();

			// sessao.close();

		} catch (HibernateException e) {
			sessao.beginTransaction().rollback();
			System.out.println("Nao foi possivel atualizar o contato. Erro"
					+ e.getMessage());

		} finally {
			sessao.close();
		}

	}

	public void remove(Cidade cidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(cidade);
		t.commit();
		}
	public void update(Cidade cidade) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(cidade);
		t.commit();
		}
	public List<Cidade> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Cidade").list();
		t.commit();
		return lista;
		}
	
	
	public List<Cidade> listByUf(){
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List lista =  session.createQuery("from Cidade where estado_idestado ").list();
		transaction.commit();
		return lista;
	}
	
	/*public static void main(String[] args) {

		Cidade cidade = new Cidade();
		cidade.setCidade("Palmas");
		Estado estado = new Estado();
		estado.setIdestado("TO");
		cidade.setEstado(estado);

		CidadeDAO dao = new CidadeDAO();
		dao.salvar(cidade);

	}*/

}
