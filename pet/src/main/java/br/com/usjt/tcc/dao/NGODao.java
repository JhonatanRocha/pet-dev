package br.com.usjt.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.usjt.tcc.model.NGO;

public class NGODao {
//Testando alteração
	private EntityManager entityManager;

	public NGODao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(NGO ngo) {
		entityManager.getTransaction().begin();
		entityManager.persist(ngo);
		entityManager.getTransaction().commit();
	}

	public void atualiza(NGO ngo) {
		entityManager.getTransaction().begin();
		entityManager.persist(ngo);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<NGO> lista() {
		Query query = entityManager.createQuery("select n from NGO n");
		return query.getResultList();
	}

	public NGO busca(Long id) {
		return entityManager.find(NGO.class, id);
	}
	
	public NGO buscaPeloDocument(String document) {
		TypedQuery<NGO> query = entityManager.createQuery(
				"select n from NGO n where n.document=:pDocument", NGO.class);

		query.setParameter("pDocument", document);
		NGO ngo = query.getSingleResult();
		return ngo;
	}
}
