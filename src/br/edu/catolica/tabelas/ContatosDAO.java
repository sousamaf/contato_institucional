package br.edu.catolica.tabelas;

import org.hibernate.*;

import br.edu.catolica.MOP.Contatos;
import br.edu.catolica.conexao.HibernateUtil;



public class ContatosDAO {
	Session sessao = null;

	Transaction transacao = null;
	public void salvar(Contatos contato)

	{



		try{

			sessao = HibernateUtil.getSessionFactory().openSession();

			transacao = sessao.beginTransaction();

			sessao.save(contato);

			transacao.commit();

			//sessao.close();

		} catch(HibernateException e) {

			System.out.println("Nao foi possivel inserir o contato. Erro" + e.getMessage());

		}

	}

	public static void main(String [] args){

		Contatos contato1 = new Contatos();

		contato1.setName("Claelton");
		contato1.setSobrenome("nascimento");
		contato1.setCpf("023.163.171-54");
		contato1.setProfissao("aluno");
		contato1.setEmail("claelton@hotmail.com");
		contato1.setEndereco("rua 2 n°20");
		contato1.setTelefone("(63)3215 5928");



		ContatosDAO contatoCrud = new ContatosDAO();

		contatoCrud.salvar(contato1);

	}



}