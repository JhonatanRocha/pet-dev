package br.com.usjt.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.usjt.tcc.model.Type;

public class TypeDao {

	private EntityManager entityManager;

	public TypeDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Type type) {
		entityManager.getTransaction().begin();
		entityManager.persist(type);
		entityManager.getTransaction().commit();
	}

	public void atualiza(Type type) {
		entityManager.getTransaction().begin();
		entityManager.merge(type);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Type> lista() {
		Query query = entityManager.createQuery("select t from Type t");
		return query.getResultList();
	}

	public Type busca(Long id) {
		return entityManager.find(Type.class, id);
	}
}