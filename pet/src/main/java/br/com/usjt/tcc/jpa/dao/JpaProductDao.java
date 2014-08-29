package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.model.Product;
import br.com.usjt.tcc.model.User;

@Repository
@Transactional
public class JpaProductDao implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public JpaProductDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public JpaProductDao() {
	}

	public void adiciona(Product product) {
		entityManager.persist(product);
	}

	public void atualiza(Product product) {
		entityManager.merge(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> lista() {
		Query query = entityManager.createQuery("select p from Product p");
		return query.getResultList();
	}

	public Product busca(Long id) {
		return entityManager.find(Product.class, id);
	}

}
