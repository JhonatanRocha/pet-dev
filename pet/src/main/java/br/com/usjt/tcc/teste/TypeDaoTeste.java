package br.com.usjt.tcc.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.usjt.tcc.dao.TypeDao;
import br.com.usjt.tcc.model.Type;

public class TypeDaoTeste {

	public static void main(String[] args) {

		Type type = new Type();
		type.setDescription("Cachorro");
		
		EntityManagerFactory entityManagerFactory = Persistence	.createEntityManagerFactory("tcc-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypeDao typeDao = new TypeDao(entityManager);

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
