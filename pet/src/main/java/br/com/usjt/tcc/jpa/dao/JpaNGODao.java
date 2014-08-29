package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.model.NGO;

@Repository
@Transactional
public class JpaNGODao implements NGODao {

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(NGO ngo) {
		entityManager.persist(ngo.getAdministrator().getAddress());
		entityManager.persist(ngo.getAdministrator());
		entityManager.persist(ngo);
	}

	public void atualiza(NGO ngo) {
		entityManager.merge(ngo);
	}

	@SuppressWarnings("unchecked")
	public List<NGO> lista() {
		Query query = entityManager.createQuery("select n from NGO n");
		return query.getResultList();
	}

	public NGO busca(Long id) {
		return entityManager.find(NGO.class, id);
	}

	public NGO buscaPeloDocument(String cnpj) {
		TypedQuery<NGO> query = entityManager.createQuery(
				"select n from NGO n where n.cnpj=:pCnpj", NGO.class);

		query.setParameter("pCnpj", cnpj);
		NGO ngo = query.getSingleResult();
		return ngo;
	}
	
	public NGO buscaPeloADM(Long id) {
		TypedQuery<NGO> query = entityManager.createQuery(
				"select n from NGO n where n.administrator_id=:pId", NGO.class);

		query.setParameter("pId", id);
		NGO ngo = query.getSingleResult();
		return ngo;
	}
}
