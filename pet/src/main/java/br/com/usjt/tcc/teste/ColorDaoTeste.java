package br.com.usjt.tcc.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.usjt.tcc.dao.ColorDao;
import br.com.usjt.tcc.model.Color;

public class ColorDaoTeste {

	public static void main(String[] args) {

		Color color = new Color();
		color.setDescription("Pardo");
		
		EntityManagerFactory entityManagerFactory = Persistence	.createEntityManagerFactory("tcc-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		ColorDao colorDao = new ColorDao(entityManager);

// TESTES:
		// CREATE
		colorDao.adiciona(color);

		// READ
		Color colorAux = colorDao.busca(new Long(1));
		System.out.println(colorAux.getDescription());
			
		// UPDATE
		colorAux.setDescription("Verde");;
		colorDao.atualiza(colorAux);

		// List
		List<Color> colors = colorDao.lista();
		for (Color c : colors) {
			System.out.println(c.getDescription());
		}
			//OR
		colors = colorDao.buscaPelaDescricao("Verde");
		for (Color c : colors) {
			System.out.println(c.getDescription());
		}
	}
}
