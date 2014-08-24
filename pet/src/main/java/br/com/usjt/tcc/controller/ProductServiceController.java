package br.com.usjt.tcc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.Product;
import br.com.usjt.tcc.model.ProductVO;
import br.com.usjt.tcc.model.Race;
import br.com.usjt.tcc.model.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping("/products")
public class ProductServiceController {

	@Autowired
	TypeDao typeDao;

	@Autowired
	RaceDao raceDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	PetShopDao petShopDao;
	
	@RequestMapping(value = "/{documento}", method = RequestMethod.POST)
	public void products(@RequestBody String productVOJson,	@PathVariable String documento, HttpServletRequest request) {
		
		PetShop petShop= petShopDao.buscaPeloDocument(documento);
				
		Gson gson = new Gson();
		List<ProductVO> productVOs = gson.fromJson(productVOJson, new TypeToken<List<ProductVO>>() {}.getType());

		List<Product> products = new ArrayList<Product>();
		
		Iterator<ProductVO> iterator = productVOs.iterator();
		while (iterator.hasNext()) {
			
			Product parseProduct = parseProduct(iterator.next());
			parseProduct.setPetShop(petShop);
			products.add(parseProduct);
		}
		
		Iterator<Product> iterator2 = products.iterator();
		while (iterator2.hasNext()) {
			productDao.adiciona(iterator2.next());
		}
		
	}

	private Product parseProduct(ProductVO productVO) {
		Product product = new Product();
		product.setName(productVO.getName());
		product.setPrice(productVO.getPrice());
		
		Race race = raceDao.busca(productVO.getRace());
		product.setRace(race);
		
		product.setScore(productVO.getScore());
		product.setSize(productVO.getSize());
		product.setStage(productVO.getStage());
		
		Type type = typeDao.busca(productVO.getType());
		product.setType(type);

		return product;
	}

}
