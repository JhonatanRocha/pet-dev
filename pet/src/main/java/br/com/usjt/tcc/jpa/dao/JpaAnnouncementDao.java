package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.AnnouncementDao;
import br.com.usjt.tcc.model.Announcement;

@Repository
@Transactional
public class JpaAnnouncementDao implements AnnouncementDao {

	@PersistenceContext
	private EntityManager entityManager;

	public JpaAnnouncementDao() {
	}

	public JpaAnnouncementDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Announcement announcement) {
		entityManager.persist(announcement);
	}

	public void atualiza(Announcement announcement) {
		entityManager.merge(announcement);
	}

	@SuppressWarnings("unchecked")
	public List<Announcement> lista() {
		Query query = entityManager.createQuery("select a from Announcement a");
		return query.getResultList();
	}

	public Announcement busca(Long id) {
		return entityManager.find(Announcement.class, id);
	}
}
