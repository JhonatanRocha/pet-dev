package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.User;

@Repository
@Transactional
public class JpaPetShopDao implements PetShopDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(PetShop petShop) {
		entityManager.persist(petShop.getAdministrator().getAddress());
		entityManager.persist(petShop.getAdministrator());
		entityManager.persist(petShop);
	}

	public void atualiza(PetShop petShop) {
		entityManager.merge(petShop);
	}

	@SuppressWarnings("unchecked")
	public List<PetShop> lista() {
		Query query = entityManager.createQuery("select p from PetShop p");
		return query.getResultList();
	}

	public PetShop busca(Long id) {
		return entityManager.find(PetShop.class, id);
	}

	public PetShop buscaPeloDocument(String cnpj) {
		TypedQuery<PetShop> query = entityManager.createQuery(
				"select p from PetShop p where p.cnpj=:pCnpj",
				PetShop.class);

		query.setParameter("pCnpj", cnpj);
		PetShop petShop = query.getSingleResult();
		return petShop;
	}

	@Override
	public PetShop buscaUserId(Long id) {
		TypedQuery<PetShop> query = entityManager.createQuery(
				"select p from PetShop p where p.administrator.id=:pId",
				PetShop.class);

		query.setParameter("pId", id);
		PetShop petShop = query.getSingleResult();
		return petShop;
	}

	@Override
	public PetShop busca(User loggedUser) {
		TypedQuery<PetShop> query = entityManager.createQuery(
				"select p from PetShop p where p.administrator.id=:pId",
				PetShop.class);

		query.setParameter("pId", loggedUser.getId());
		PetShop petShop = query.getSingleResult();
		return petShop;
	}
}
