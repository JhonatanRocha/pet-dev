package br.com.usjt.tcc.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.usjt.tcc.dao.RaceDao;
import br.com.usjt.tcc.model.Race;

public class RaceDaoTeste {

	public static void main(String[] args) {

		Race race = new Race();
		race.setDescription("Pug");
		
		EntityManagerFactory entityManagerFactory = Persistence	.createEntityManagerFactory("tcc-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		RaceDao raceDao = new RaceDao(entityManager);

// TESTES:
		// CREATE
		raceDao.adiciona(race);

		// READ
		Race raceAux = raceDao.busca(new Long(1));
		System.out.println(raceAux.getDescription());
			
		// UPDATE
		raceAux.setDescription("Pincher");;
		raceDao.atualiza(raceAux);

		// List
		List<Race> races = raceDao.lista();
		for (Race r : races) {
			System.out.println(r.getDescription());
		}
			//OR
		races = raceDao.buscaPelaDescricao("Pincher");
		for (Race c : races) {
			System.out.println(c.getDescription());
		}
	}
}
