package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.AlertDao;
import br.com.usjt.tcc.model.Alert;

@Repository
@Transactional
public class JpaAlertDao implements AlertDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Alert alert) {
		entityManager.persist(alert);
	}

	public void atualiza(Alert alert) {
		entityManager.merge(alert);
	}

	@SuppressWarnings("unchecked")
	public List<Alert> lista() {
		Query query = entityManager.createQuery("select a from Alert a");
		return query.getResultList();
	}

	public Alert busca(Long id) {
		return entityManager.find(Alert.class, id);
	}
}