package br.edu.catolica.tabelas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.catolica.MOP.Cidade;
import br.edu.catolica.MOP.Cliente;
import br.edu.catolica.MOP.Funcionario;
import br.edu.catolica.MOP.Telefone;
import br.edu.catolica.conexao.HibernateUtil;

public class FuncionarioDAO {
	

	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Funcionario funcionario)

	{



		try{

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(funcionario);

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
	public void remove(Funcionario funcionario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(funcionario);
		t.commit();
		}
	public void update(Funcionario funcionario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(funcionario);
		t.commit();
		}
	public List<Funcionario> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from funcionario").list();
		t.commit();
		return lista;
		}
	public static void main(String [] args){
		Cidade cidade = new Cidade();
		cidade.setIdcidade(1);
		/*Telefone telefone = new Telefone();
		telefone.setIdtelefone(1);
		
		
		Cliente cliente = new Cliente();
		cliente.setNome("Claelton Nascimento");
		cliente.setEmail("claelto_nascimento@hotmail.com");
		cliente.setEndereco("Rua soares n° 1000");
		cliente.setCidade(cidade);
		cliente.setTelefone(telefone);
		*/
		String  dataii;
		Date data =  new Date();
		try{
			String dataV = "22/22/2222";
			 
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataV);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Funcionario funcionario = new Funcionario(1, data, 101, "cargo", 111,"nome", "endereco", "email", cidade);
		//funcionario.setMatricula(123);
		/* funcionario.setAdmissao(data);
		funcionario.setCargo("Gerente");
		funcionario.setSalario(692);
		funcionario.setIdcliente(3);
		*/
		
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.salvar(funcionario);
		
				



	}



}
