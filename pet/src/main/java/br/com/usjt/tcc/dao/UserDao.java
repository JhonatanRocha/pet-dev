package br.com.usjt.tcc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.model.User;

public class UserDao {

	private EntityManager entityManager;

	public UserDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user.getAddress());
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	public void atualiza(User user) {
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<User> lista() {
		Query query = entityManager.createQuery("select u from User u");
		return query.getResultList();
	}

	public User busca(Long id) {
		return entityManager.find(User.class, id);
	}

	public User buscaPeloEmail(String email) {
		TypedQuery<User> query = entityManager.createQuery(
				"select u from User u where u.email=:pEmail", User.class);

		query.setParameter("pEmail", email);
		User user = query.getSingleResult();
		return user;
	}

	public boolean existeUser(User user) {
		TypedQuery<Long> query = entityManager
				.createQuery(
						"SELECT COUNT(u) FROM User u WHERE u.email=:pEmail",
						Long.class);

		query.setParameter("pEmail", user.getEmail());

		Long flag = query.getSingleResult();

		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}

}
