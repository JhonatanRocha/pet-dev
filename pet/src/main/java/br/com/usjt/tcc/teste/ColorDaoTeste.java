package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.ColorDao;
import br.com.usjt.tcc.model.Color;

@Component
public class ColorDaoTeste {

	@Autowired
	private ColorDao colorDao;
	
	public void test() {

		Color color = new Color();
		color.setDescription("Pardo");

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
