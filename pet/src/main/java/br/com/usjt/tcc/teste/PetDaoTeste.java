package br.com.usjt.tcc.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.usjt.tcc.dao.ColorDao;
import br.com.usjt.tcc.dao.PetDao;
import br.com.usjt.tcc.dao.RaceDao;
import br.com.usjt.tcc.dao.TypeDao;
import br.com.usjt.tcc.enun.Size;
import br.com.usjt.tcc.model.Pet;

public class PetDaoTeste {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence	.createEntityManagerFactory("tcc-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Pet pet = new Pet();
		pet.setDeficiency("Fisica");
		pet.setGender("M");
		pet.setIsCastrated(false);
		pet.setIsDeficient(true);
		pet.setName("Bruce");
		pet.setPicturePath("\fotos\bruce");
		pet.setSize(Size.BIG);
		pet.setRace(new RaceDao(entityManager).busca(new Long(1)));
		pet.setType(new TypeDao(entityManager).busca(new Long(1)));
		pet.setColor(new ColorDao(entityManager).busca(new Long(1)));
		
		
		PetDao petDao = new PetDao(entityManager);

// TESTES:
		// CREATE
		petDao.adiciona(pet);

		// READ
		Pet petAux = petDao.busca(new Long(1));
		System.out.println(petAux.getName());
			
		// UPDATE
		petAux.setName("Rex");
		petAux.setColor(new ColorDao(entityManager).busca(new Long(1)));
		petDao.atualiza(petAux);
		
		// List
		List<Pet> pets = petDao.lista();
		for (Pet p : pets) {
			System.out.println(p.getName());
		}
	}
}
