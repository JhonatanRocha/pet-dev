package br.com.usjt.tcc.webservice;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.usjt.tcc.enun.Size;
import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.model.Product;
import br.com.usjt.tcc.model.Race;
import br.com.usjt.tcc.model.Type;

@Stateless
@WebService(endpointInterface = "br.com.usjt.tcc.webservice.Product")
public class ProductWSImpl implements ProductWS {

	@Autowired
	ProductDao productDao;

	public ReturnWS request(String idCompany, ProductBean[] listProduct) {

		insertValuesInProduct(listProduct);

		ReturnWS returnWs = new ReturnWS();
		returnWs.setCode(999);
		returnWs.setDescription("Erro ao executar");
		
		return returnWs;
	}

	private void insertValuesInProduct(ProductBean[] listProduct) {

		try {
			Product product = new Product();
			Race race = new Race();
			Type type = new Type();
			
			for (ProductBean s : listProduct) {

				product.setName(s.getName());
				product.setPrice(s.getPrice().doubleValue());
				product.setScore(s.getScore());
				product.setStage(s.getStage());
				product.setSizeOfPet(Size.valueOf(s.getSizeOfPet()));
				type.setDescription(s.getTypeOfPet());
				product.setTypeOfPet(type);
				race.setDescription(s.getRaca());
				product.setRaca(race);

				productDao.adiciona(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}