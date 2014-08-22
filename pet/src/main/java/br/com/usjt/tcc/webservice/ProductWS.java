package br.com.usjt.tcc.webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ProductWS {
	@WebMethod
	ReturnWS request (String idCompany, ProductBean[] listTeste);
	
}