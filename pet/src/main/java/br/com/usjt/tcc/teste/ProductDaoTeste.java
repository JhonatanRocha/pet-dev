package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.Product;

@Component
public class ProductDaoTeste {

	@Autowired 
	private ProductDao productDao;
	@Autowired 
	private RaceDao raceDao;
	@Autowired 
	private TypeDao typeDao;
	
	
	public void test() {

		Product product = new Product();
		product.setName("Shampoo");
		product.setPrice(new Double(2.2));
		product.setRaca(raceDao.busca(new Long(1)));
		product.setScore(2000);
		product.setSizeOfPet("BIG");
		product.setStage("Nao sei o q e stage");
		product.setTypeOfPet(typeDao.busca(new Long(1)));
		
// TESTES:
		// CREATE
		productDao.adiciona(product);

		// READ
		Product productAux = productDao.busca(new Long(1));
		System.out.println(productAux.getName());
			
		// UPDATE
		productAux.setPrice(new Double(1.8));
		productAux.setRaca(raceDao.busca(new Long(1)));;
		productDao.atualiza(productAux);
		
		// List
		List<Product> products = productDao.lista();
		for (Product p : products) {
			System.out.println(p.getName());
		}
	}
}
