package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Address;
import br.com.usjt.tcc.model.User;

@Component
public class UserDaoTeste {

	@Autowired
	private UserDao userDao;
	
	public void test() {

		User user = new User();
		user.setName("Ronaldo");
		user.setEmail("ronaldo@email.com");
		user.setCellphone("987816876");
		user.setPhone("27419489");
		user.setPassword("dsfwd4w1");
		user.setIsOwner(true);
		user.setIsOfPetShop(false);
		user.setIsOfNGO(false);

		Address address = new Address();
		address.setStreet("av. paulista");
		address.setZipcode("08811110");
		address.setCity("Sao Paulo");
		address.setState("SP");

		user.setAddress(address);

// TESTES:
		// CREATE
		userDao.adiciona(user);

		// READ
		User userAux = userDao.busca(new Long(1));
		System.out.println(userAux.getName());
			// OR
		userAux = userDao.buscaPeloEmail(user.getEmail());
		System.out.println(userAux.getName());

		// UPDATE
		userAux.setCellphone("978041168");
		userAux.getAddress().setStreet("sezame street");
		userDao.atualiza(userAux);

		// List
		List<User> users = userDao.lista();
		for (User u : users) {
			System.out.println(u.getEmail());
		}

		// Verify if exists in data base
		boolean hasUser = userDao.existeUser(userAux);
		System.out.println(hasUser);

	}
}
