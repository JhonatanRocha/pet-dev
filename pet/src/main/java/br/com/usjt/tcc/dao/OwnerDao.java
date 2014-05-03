package br.com.usjt.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.usjt.tcc.model.Owner;

public class OwnerDao {

	private EntityManager entityManager;

	public OwnerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Owner owner) {
		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.getTransaction().commit();
	}

	public void atualiza(Owner owner) {
		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Owner> lista() {
		Query query = entityManager.createQuery("select o from Owner o");
		return query.getResultList();
	}

	public Owner busca(Long id) {
		return entityManager.find(Owner.class, id);
	}

}
