package br.edu.catolica.tabelas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Cliente;
import br.edu.catolica.MOP.Fisico;
import br.edu.catolica.MOP.Genero;
import br.edu.catolica.conexao.HibernateUtil;

public class FisicoDao {
	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Fisico fisico)

	{



		try{

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(fisico);

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
	public void remove(Fisico fisico) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(fisico);
		t.commit();
		}
	public void update(Fisico fisico) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(fisico);
		t.commit();
		}
	public List<Fisico> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from fisico").list();
		t.commit();
		return lista;
		}
	public static void main(String [] args){
		Genero genero = new Genero();
		genero.setIdgenero(1);
		
		String  dataii;
		Date data =  new Date();
		try{
			String dataV = "22/22/2222";
			 
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataV);
		}catch(Exception e){
			e.printStackTrace();
		}
		Cidade cidade = new Cidade();
		cidade.setIdcidade(1);
		
		Fisico fisico = new Fisico("cpf"," rg"," estado_civil", data, genero, 11, "nome1", "endereco1", "email1", cidade);
		
		FisicoDao dao = new FisicoDao();
		dao.salvar(fisico);
		
		
	}
	}

