package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.model.Race;

@Component
public class RaceDaoTeste {

	@Autowired
	private RaceDao raceDao;
	
	public void test() {

		Race race = new Race();
		race.setDescription("Pug");

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
