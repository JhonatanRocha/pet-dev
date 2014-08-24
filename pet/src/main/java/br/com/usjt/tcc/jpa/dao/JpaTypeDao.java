package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.Type;

@Repository
@Transactional
public class JpaTypeDao implements TypeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Type type) {
		entityManager.persist(type);
	}

	public void atualiza(Type type) {
		entityManager.merge(type);
	}

	@SuppressWarnings("unchecked")
	public List<Type> lista() {
		Query query = entityManager.createQuery("select t from Type t");
		return query.getResultList();
	}

	public Type busca(Long id) {
		return entityManager.find(Type.class, id);
	}

	@Override
	public Type busca(String type) {
		
		TypedQuery<Type> query = entityManager
				.createQuery("select t from Type t where t.description=:tDescription",	Type.class);
	
		query.setParameter("tDescription", type);
		
		return  query.getSingleResult();
	}
}