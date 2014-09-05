package br.com.usjt.tcc.teste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.RuleDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.Rule;

@Component
public class RuleDaoTeste {

	@Autowired 
	private ProductDao productDao;
	@Autowired 
	private RaceDao raceDao;
	@Autowired 
	private TypeDao typeDao;
	@Autowired
	private RuleDao ruleDao;
	
	
	public void test() {

		Rule rule = new Rule();
		rule.setName("Regra Genérica");
		rule.setRace(false);
		rule.setScore(false);
		rule.setSize(false);
		rule.setProduct(productDao.busca((long) 1));
		rule.setStage(false);
		rule.setType(false);
		
		ruleDao.adiciona(rule);
		
		Rule ruleAux = ruleDao.busca(new Long(1));
		System.out.println(ruleAux.getName());
		
		ruleAux.setName("Deu a louca no Gerente!");
		ruleAux.setSize(false);
		ruleDao.atualiza(ruleAux);
		
		List<Rule> rules = ruleDao.lista();
		for (Rule r : rules) {
			System.out.println("Listando: " + r.getName());
			System.out.println("Listando: " + r.getScore());
			System.out.println("Listando: " + r.getProduct().getId());
		}

	}
}
