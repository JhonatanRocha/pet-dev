package br.com.usjt.tcc.teste;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Address;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.User;

@Component
public class PetShopDaoTeste {

	@Autowired
	private PetShopDao petShopDao;
	@Autowired 
	private ProductDao productDao;
	@Autowired 
	private UserDao userDao;
	
	public void test() {

 		PetShop petShop = new PetShop();
 		petShop.setCnpj("36272923");
 		petShop.setName("PetBoys");
 		petShop.setSite("www.petboys.com");
 		
 		User user = new User();
		user.setName("Ronaldo");
		user.setEmail("donodopet@email.com");
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
		
 		petShop.setAdministrator(user);
 		petShop.setUsers(userDao.lista());
 		petShop.setProducts(productDao.lista());
 				
// TESTES:
		// CREATE
		petShopDao.adiciona(petShop);

		// READ
		PetShop petShopAux = petShopDao.busca(new Long(1));
		System.out.println(petShopAux.getSite());
			
		// UPDATE
		petShopAux.setSite("www.outravezcafe.com.br");
		petShopDao.atualiza(petShopAux);
		
		// List
		List<PetShop> petShops = petShopDao.lista();
		for (PetShop p : petShops) {
			System.out.println(p.getSite());
		}
	}
}
