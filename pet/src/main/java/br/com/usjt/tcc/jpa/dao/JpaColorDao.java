package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.ColorDao;
import br.com.usjt.tcc.model.Color;

@Repository
@Transactional
public class JpaColorDao implements ColorDao{

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Color color) {
		entityManager.persist(color);
	}

	public void atualiza(Color color) {
		entityManager.merge(color);
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