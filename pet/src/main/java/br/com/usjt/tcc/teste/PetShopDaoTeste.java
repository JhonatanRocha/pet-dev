package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.PetShop;

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
 		petShop.setAdministrator(userDao.busca(new Long(1)));
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
		petShopAux.setAdministrator(userDao.busca(new Long(1)));
		petShopDao.atualiza(petShopAux);
		
		// List
		List<PetShop> petShops = petShopDao.lista();
		for (PetShop p : petShops) {
			System.out.println(p.getSite());
		}
	}
}
