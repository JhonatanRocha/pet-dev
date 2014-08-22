package br.com.usjt.tcc.webservice;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "br.com.usjt.tcc.webservice.Product")
public class ProductWSImpl implements ProductWS {
	public String request(ProductBean[] listProduct) {
		if (listProduct == null)
			return null;
		String teste = "0";
		return (String) teste;
	}
}