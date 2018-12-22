package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Turno;

/**
 * Classe responsável por persistir a classe Turno no banco de dados.
 * 
 * @author Fernanda Viana
 * @version 2.0.0 - 01/06/2018
 */
public class TurnoDAO {

	private EntityManager manager;

	public TurnoDAO() {
		super();

		this.manager = JPAUtil.getEntityManager();
	}

	public Turno salvar(Turno turno) {
		this.manager.getTransaction().begin();
		turno = this.manager.merge(turno);
		this.manager.getTransaction().commit();
		return turno;
	}

	public void excluir(Turno turno) {
		this.manager.getTransaction().begin();
		this.manager.remove(turno);
		this.manager.getTransaction().commit();
	}

	public Turno alterar(Integer codigo) {
		return this.manager.find(Turno.class, codigo);
	}

	public List<Turno> listar() {

		String jpql = "from Turno t order by t.nome";

		List<Turno> lista = this.manager.createQuery(jpql, Turno.class).getResultList();

		return lista;
	}

}

