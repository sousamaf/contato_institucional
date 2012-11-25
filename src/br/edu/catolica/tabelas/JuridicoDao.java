package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Funcionario;
import br.edu.catolica.MOP.Juridico;
import br.edu.catolica.conexao.HibernateUtil;

public class JuridicoDao {
	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Juridico juridico)

	{



		try{

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(juridico);

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
	public void remove(Juridico juridico) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(juridico);
		t.commit();
		}
	public void update(Juridico juridico) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(juridico);
		t.commit();
		}
	public List<Juridico> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from cidade").list();
		t.commit();
		return lista;
		}
	public static void main(String [] args){
		Cidade cidade = new Cidade();
		cidade.setIdcidade(1);
		Juridico juridico = new Juridico("razao", "cnpj", "e_estadual"," descricao", 22, "nome", "endereco", "email", cidade);
		
		JuridicoDao dao = new JuridicoDao();
		dao.salvar(juridico);
}
}