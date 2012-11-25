package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Genero;
import br.edu.catolica.MOP.Telefone;
import br.edu.catolica.conexao.HibernateUtil;

public class GeneroDao {

	Session sessao = null;

	Transaction transacao = null;

	public void salvar(Genero genero)

	{

		{

			try {

				sessao = HibernateUtil.getSessionFactory().openSession();

				transacao = sessao.beginTransaction();

				sessao.save(genero);

				transacao.commit();

				// sessao.close();

			} catch (HibernateException e) {
				sessao.beginTransaction().rollback();
				System.out.println("Nao foi possivel inserir o contato. Erro"
						+ e.getMessage());

			} finally {
				sessao.close();
			}
		}

	}
	public void remove(Genero genero) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(genero);
		t.commit();
		}
	public void update(Genero genero) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(genero);
		t.commit();
		}
	public List<Genero> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from genero").list();
		t.commit();
		return lista;
		}
	public static void main(String[] args) {

		Genero genero = new Genero();
		genero.setSexo("M");

		GeneroDao dao = new GeneroDao();
		dao.salvar(genero);

	}

}
