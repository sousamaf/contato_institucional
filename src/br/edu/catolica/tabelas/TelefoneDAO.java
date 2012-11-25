package br.edu.catolica.tabelas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.security.ntlm.Client;

import br.edu.catolica.TelefoneBean;
import br.edu.catolica.MOP.Cliente;
import br.edu.catolica.MOP.Estado;
import br.edu.catolica.MOP.Juridico;
import br.edu.catolica.MOP.Telefone;
import br.edu.catolica.conexao.HibernateUtil;

public class TelefoneDAO {
	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Telefone telefone)

	{


		{



			try{

				sessao = HibernateUtil.getSessionFactory().openSession();

				transacao = sessao.beginTransaction();

				sessao.save(telefone);

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

		}
	public void remove(Telefone telefone) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(telefone);
		t.commit();
		}
	public void update(Telefone telefone) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(telefone);
		t.commit();
		}
	public List<Telefone> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from telefone").list();
		t.commit();
		return lista;
	}
		/*public static void main(String [] args){
			Cliente cliente = new Cliente();
			cliente.setIdcliente(2);
			
			
			Telefone telefone = new Telefone();
			telefone.setTipo("celular");
			telefone.setTelefone("8445 2145");
			telefone.setCliente(cliente);
			
			TelefoneDAO dao = new TelefoneDAO();
			dao.salvar(telefone);
			
					

			






		}

*/
}
