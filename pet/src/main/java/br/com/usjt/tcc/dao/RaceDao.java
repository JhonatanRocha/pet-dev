package br.com.usjt.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.usjt.tcc.model.Race;

public class RaceDao {
	private EntityManager entityManager;

	public RaceDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Race race) {
		entityManager.getTransaction().begin();
		entityManager.persist(race);
		entityManager.getTransaction().commit();
	}

	public void atualiza(Race race) {
		entityManager.getTransaction().begin();
		entityManager.merge(race);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Race> lista() {
		Query query = entityManager.createQuery("select r from Race r");
		return query.getResultList();
	}

	public Race busca(Long id) {
		return entityManager.find(Race.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Race> buscaPelaDescricao(String description) {
		Query query = entityManager
				.createQuery("select r from Race r where r.description=:pDescription");

		query.setParameter("pDescription", description);

		return query.getResultList();
	}
}