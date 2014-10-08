package br.com.usjt.tcc.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.usjt.tcc.interfaces.dao.VoucherDao;
import br.com.usjt.tcc.model.Voucher;

@Repository
@Transactional
public class JpaVoucherDao implements VoucherDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void adiciona(Voucher voucher) {
		entityManager.persist(voucher);
	}

	public void atualiza(Voucher voucher) {
		entityManager.merge(voucher);
	}

	@SuppressWarnings("unchecked")
	public List<Voucher> lista() {
		Query query = entityManager.createQuery("select v from Voucher v");
		return query.getResultList();
	}

	public Voucher busca(Long id) {
		return entityManager.find(Voucher.class, id);
	}

}