package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.NGO;

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
		ngo.setAdministrator(userDao.busca(new Long(1)));
				
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
		ngoAux.setAdministrator(userDao.busca(new Long(1)));
		ngoDao.atualiza(ngoAux);
		
		// List
		List<NGO> ngos = ngoDao.lista();
		for (NGO n : ngos) {
			System.out.println(n.getSite());
		}
	}
}
