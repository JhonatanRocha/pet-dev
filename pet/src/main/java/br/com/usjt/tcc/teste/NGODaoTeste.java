package br.com.usjt.tcc.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.usjt.tcc.dao.NGODao;
import br.com.usjt.tcc.dao.PetDao;
import br.com.usjt.tcc.dao.UserDao;
import br.com.usjt.tcc.model.NGO;

public class NGODaoTeste {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence	.createEntityManagerFactory("tcc-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		NGO ngo = new NGO();
		ngo.setDocument("333444");
		ngo.setSite("www.ong.com.br");
		ngo.setPets(new PetDao(entityManager).lista());
		ngo.setUsers(new UserDao(entityManager).lista());
		ngo.setAdministrator(new UserDao(entityManager).busca(new Long(1)));
				
		NGODao ngoDao = new NGODao(entityManager);

// TESTES:
		// CREATE
		ngoDao.adiciona(ngo);

		// READ
		NGO ngoAux = ngoDao.busca(new Long(1));
		System.out.println(ngoAux.getSite());
			//OR
		ngoAux = ngoDao.buscaPeloDocument("333444");
		System.out.println(ngoAux.getSite());
		
		// UPDATE
		ngoAux.setSite("www.outravezcafe.com.br");
		ngoAux.setAdministrator(new UserDao(entityManager).busca(new Long(1)));
		ngoDao.atualiza(ngoAux);
		
		// List
		List<NGO> ngos = ngoDao.lista();
		for (NGO n : ngos) {
			System.out.println(n.getSite());
		}
	}
}
