package br.com.usjt.tcc.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.usjt.tcc.dao.OwnerDao;
import br.com.usjt.tcc.dao.PetDao;
import br.com.usjt.tcc.dao.UserDao;
import br.com.usjt.tcc.model.Owner;

public class OwnerDaoTeste {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence	.createEntityManagerFactory("tcc-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Owner owner = new Owner();
		
		Calendar birth = Calendar.getInstance();
		birth.set(2014, 12, 24);
		owner.setBirth(birth);
		owner.setScore(990);
		owner.setPets(new PetDao(entityManager).lista());
		owner.setUser(new UserDao(entityManager).busca(new Long(1)));
				
		OwnerDao ownerDao = new OwnerDao(entityManager);

// TESTES:
		// CREATE
		ownerDao.adiciona(owner);

		// READ
		Owner ownerAux = ownerDao.busca(new Long(1));
		System.out.println(ownerAux.getScore());
		
		// UPDATE
		ownerAux.setScore(123);
		ownerAux.setUser(new UserDao(entityManager).busca(new Long(1)));
		ownerDao.atualiza(ownerAux);
		
		// List
		List<Owner> owners = ownerDao.lista();
		for (Owner o : owners) {
			System.out.println(o.getScore());
		}
	}
}
