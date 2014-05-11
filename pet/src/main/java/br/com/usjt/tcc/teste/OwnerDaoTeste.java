package br.com.usjt.tcc.teste;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.usjt.tcc.interfaces.dao.OwnerDao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Owner;

@Component
public class OwnerDaoTeste {

	@Autowired
	private PetDao petDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OwnerDao ownerDao;
	
	public void test() {
		Owner owner = new Owner();
		
		Calendar birth = Calendar.getInstance();
		birth.set(2014, 12, 24);
		owner.setBirth(birth);
		owner.setScore(990);
		owner.setPets(petDao.lista());
		owner.setUser(userDao.busca(new Long(1)));
				
	
// TESTES:
		// CREATE
		ownerDao.adiciona(owner);

		// READ
		Owner ownerAux = ownerDao.busca(new Long(1));
		System.out.println(ownerAux.getScore());
		
		// UPDATE
		ownerAux.setScore(123);
		ownerAux.setUser(userDao.busca(new Long(1)));
		ownerDao.atualiza(ownerAux);
		
		// List
		List<Owner> owners = ownerDao.lista();
		for (Owner o : owners) {
			System.out.println(o.getScore());
		}
	}
}
