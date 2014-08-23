package br.com.usjt.tcc.teste;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.usjt.tcc.enun.Size;
import br.com.usjt.tcc.interfaces.dao.ColorDao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.Pet;

@Component
public class PetDaoTeste {

	@Autowired
	private RaceDao raceDao;
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private PetDao petDao;
	
	public void test() {
		Pet pet = new Pet();
		pet.setDeficiency("Fisica");
		pet.setGender("M");
		pet.setIsDeficient(false);
		pet.setIsDeficient(true);
		pet.setName("Bruce");
		pet.setSize(""+Size.BIG);
		pet.setRace(raceDao.busca(new Long(1)));
		pet.setType(typeDao.busca(new Long(1)));
		pet.setColor(colorDao.busca(new Long(1)));

// TESTES:
		// CREATE
		petDao.adiciona(pet);

		// READ
		Pet petAux = petDao.busca(new Long(1));
		System.out.println(petAux.getName());
			
		// UPDATE
		petAux.setName("Rex");
		petAux.setColor(colorDao.busca(new Long(1)));
		petDao.atualiza(petAux);
		
		// List
		List<Pet> pets = petDao.lista();
		for (Pet p : pets) {
			System.out.println(p.getName());
		}
	}
}
