package br.com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.ColorDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.Color;
import br.com.usjt.tcc.model.Race;
import br.com.usjt.tcc.model.Type;

@Controller
public class PopulaBaseController {

	@Autowired
	private TypeDao typeDao;

	@Autowired
	private RaceDao raceDao;

	@Autowired
	private ColorDao colorDao;

	@RequestMapping("populaType")
	public void populaType() {
		Type type = new Type();

		type.setDescription("Cachorro");
		typeDao.adiciona(type);

		Type type2 = new Type();
		type2.setDescription("Gato");
		typeDao.adiciona(type2);
	}

	@RequestMapping("populaRace")
	public void populaRace() {
		Race race = new Race();

		race.setDescription("Dalmata");
		raceDao.adiciona(race);

		Race race2 = new Race();

		race2.setDescription("Pug");
		raceDao.adiciona(race2);

	}

	@RequestMapping("populaColor")
	public void populaColor() {
		Color color = new Color();

		color.setDescription("Pardo");
		colorDao.adiciona(color);

		Color color2 = new Color();

		color2.setDescription("Branco");
		colorDao.adiciona(color2);

		Color color3 = new Color();

		color3.setDescription("Preto");
		colorDao.adiciona(color3);
	}

	@RequestMapping("populaAll")
	public void populaAll() {
		populaType();
		populaRace();
		populaColor();
	}
}
