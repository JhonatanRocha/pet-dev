package br.com.usjt.tcc.webservice;

import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.usjt.tcc.enun.Size;
import br.com.usjt.tcc.jdbc.dao.JDBCProductDao;
import br.com.usjt.tcc.model.Product;
import br.com.usjt.tcc.model.Race;
import br.com.usjt.tcc.model.Type;

@Stateless
@WebService(endpointInterface = "br.com.usjt.tcc.webservice.Product")
public class ProductWSImpl implements ProductWS  {

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
			
			JDBCProductDao dao = new JDBCProductDao();
			
			for (ProductBean s : listProduct) {

				product.setName(s.getName());
				product.setPrice(s.getPrice().doubleValue());
				product.setScore(s.getScore());
				product.setStage(s.getStage());
				product.setSize(""+Size.valueOf(s.getSizeOfPet()));
				type.setDescription(s.getTypeOfPet());
				product.setType(type);
				race.setDescription(s.getRaca());
				product.setRace(race);
				//this.productDao = getWebApplicationContext().getBean("accountService");
				//productDao.adiciona(product);
				dao.adiciona(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}