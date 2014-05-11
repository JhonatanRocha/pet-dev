package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.Type;

@Component
public class TypeDaoTeste {

	@Autowired
	private TypeDao typeDao; 
 	
	public void test(){

		Type type = new Type();
		type.setDescription("Cachorro");


// TESTES:
		// CREATE
		typeDao.adiciona(type);

		// READ
		Type typeAux = typeDao.busca(new Long(1));
		System.out.println(typeAux.getDescription());
	
		// UPDATE
		typeAux.setDescription("Bechano");;
		typeDao.atualiza(typeAux);

		// List
		List<Type> types = typeDao.lista();
		for (Type t : types) {
			System.out.println(t.getDescription());
		}
	}
}
