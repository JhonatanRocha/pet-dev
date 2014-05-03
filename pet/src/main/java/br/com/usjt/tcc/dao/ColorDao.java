package br.com.usjt.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.usjt.tcc.model.Color;

public class ColorDao {
	private EntityManager entityManager;

	public ColorDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Color color) {
		entityManager.getTransaction().begin();
		entityManager.persist(color);
		entityManager.getTransaction().commit();
	}

	public void atualiza(Color color) {
		entityManager.getTransaction().begin();
		entityManager.merge(color);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Color> lista() {
		Query query = entityManager.createQuery("select c from Color c");
		return query.getResultList();
	}

	public Color busca(Long id) {
		return entityManager.find(Color.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Color> buscaPelaDescricao(String description) {
		Query query = entityManager
				.createQuery("select c from Color c where c.description=:pDescription");

		query.setParameter("pDescription", description);

		return query.getResultList();
	}
}