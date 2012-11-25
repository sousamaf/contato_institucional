package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.ClienteRN;
import br.edu.catolica.TelefoneBean;
import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Cliente;
import br.edu.catolica.MOP.Estado;
import br.edu.catolica.MOP.Telefone;
import br.edu.catolica.conexao.HibernateUtil;

public class ClienteDAO {
	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Cliente cliente)

	{



		try{

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(cliente);

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
		public void remove(Cliente cliente) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			session.delete(cliente);
			t.commit();
			}
		public void update(Cliente cliente) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			session.update(cliente);
			t.commit();
			}
		public List<Cliente> list() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			List lista = session.createQuery("from cliente").list();
			t.commit();
			return lista;
			}
	

	public static void main(String [] args){
		

		
		Cidade cidade = new Cidade();
		cidade.setIdcidade(1);
		
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Kllaelton Nascimento");
		cliente.setEmail("kllaelto_nascimento@hotmail.com");
		cliente.setEndereco("Rua soares n° 1000");
		cliente.setCidade(cidade);
		
		
		
		
		ClienteDAO dao = new ClienteDAO();
		dao.remove(cliente);
		System.out.println("removido");
		}



}

