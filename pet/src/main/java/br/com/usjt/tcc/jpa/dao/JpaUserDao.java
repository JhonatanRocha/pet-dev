package br.com.usjt.tcc.jpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.User;

@Repository
@Transactional
public class JpaUserDao implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(User user) {
		entityManager.persist(user.getAddress());
		entityManager.persist(user);
	}

	public void atualiza(User user) {
		entityManager.merge(user);
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
						"SELECT COUNT(u) FROM User u WHERE u.email=:pEmail and u.password=:pSenha",
						Long.class);

		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pSenha", user.getPassword());

		return (query.getSingleResult() > 0);

	}

}
