package br.com.usjt.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.usjt.tcc.model.Pet;

public class PetDao {

	private EntityManager entityManager;

	public PetDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Pet pet) {
		entityManager.getTransaction().begin();
		entityManager.persist(pet);
		entityManager.getTransaction().commit();
	}

	public void atualiza(Pet pet) {
		entityManager.getTransaction().begin();
		entityManager.persist(pet);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Pet> lista() {
		Query query = entityManager.createQuery("select p from Pet p");
		return query.getResultList();
	}

	public Pet busca(Long id) {
		return entityManager.find(Pet.class, id);
	}

}
