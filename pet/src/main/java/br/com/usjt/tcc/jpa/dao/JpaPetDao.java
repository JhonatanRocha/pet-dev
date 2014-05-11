package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.model.Pet;

@Repository
@Transactional
public class JpaPetDao implements PetDao{

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Pet pet) {
		entityManager.persist(pet);
	}

	public void atualiza(Pet pet) {
		entityManager.merge(pet);
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
