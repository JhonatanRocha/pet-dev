package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.OwnerDao;
import br.com.usjt.tcc.model.Owner;

@Repository
@Transactional
public class JpaOwnerDao implements OwnerDao{

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Owner owner) {
		entityManager.persist(owner);
	}

	public void atualiza(Owner owner) {
		entityManager.merge(owner);
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
