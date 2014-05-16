package br.com.usjt.tcc.teste;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Address;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.User;

@Component
public class NGODaoTeste {

	@Autowired
	private NGODao ngoDao;
	@Autowired
	private PetDao petDao;
	@Autowired
	private UserDao userDao;
	
	public void test() {

		NGO ngo = new NGO();
		ngo.setCnpj("333444");
		ngo.setSite("www.ong.com.br");
		ngo.setPets(petDao.lista());
		ngo.setUsers(userDao.lista());
		
		User user = new User();
		user.setName("Ronaldo");
		user.setEmail("donodaong@email.com");
		user.setCellphone("987816876");
		user.setPhone("27419489");
		user.setPassword("dsfwd4w1");
		user.setIsOfPetShop(false);
		user.setIsOfNGO(false);
		user.setScore(990);
		Calendar birth = Calendar.getInstance();
		birth.set(2014, 12, 24);
		user.setBirth(birth);
		
		Address address = new Address();
		address.setStreet("av. paulista");
		address.setZipcode("08811110");
		address.setCity("Sao Paulo");
		address.setState("SP");

		user.setAddress(address);
		
		ngo.setAdministrator(user);
				
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
		ngoDao.atualiza(ngoAux);
		
		// List
		List<NGO> ngos = ngoDao.lista();
		for (NGO n : ngos) {
			System.out.println(n.getSite());
		}
	}
}
