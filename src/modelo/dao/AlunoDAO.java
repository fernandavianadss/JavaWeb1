package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Aluno;

/**
 * Classe responsável por permitir a classe Aluno no banco de dados.
 * 
 * @author Fernanda Viana
 * @version 2.0.0 - 01/06/2018
 *
 */
public class AlunoDAO {
	
	private EntityManager manager;
	
	public AlunoDAO(){
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public Aluno salvar(Aluno aluno) {
		this.manager.getTransaction().begin();
		aluno = this.manager.merge(aluno);
		this.manager.getTransaction().commit();
		return aluno;
	}
	
	public void excluir(Aluno aluno) {
		this.manager.getTransaction().begin();
		this.manager.remove(aluno);
		this.manager.getTransaction().commit();
		
	}
	
	public Aluno alterar(Integer matricula) {
		return this.manager.find(Aluno.class, matricula);
	}
	
	public List<Aluno> listar(){
		String jpql = "from Aluno a order by a.nome";
		
		List<Aluno> lista = this.manager.createQuery(jpql, Aluno.class).getResultList();
		
		return lista;
	}
}

