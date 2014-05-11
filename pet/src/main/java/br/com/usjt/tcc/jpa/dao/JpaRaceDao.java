package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.model.Race;

@Repository
@Transactional
public class JpaRaceDao implements RaceDao{

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Race race) {
		entityManager.persist(race);
	}

	public void atualiza(Race race) {
		entityManager.merge(race);
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