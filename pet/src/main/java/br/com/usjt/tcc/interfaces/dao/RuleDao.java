package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Rule;

public interface RuleDao {

	public void adiciona(Rule rule);

	public void atualiza(Rule rule);

	public List<Rule> lista();

	public Rule busca(Long id);

}
