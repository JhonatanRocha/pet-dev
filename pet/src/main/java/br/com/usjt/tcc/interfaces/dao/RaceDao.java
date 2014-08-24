package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Race;

public interface RaceDao {
	public void adiciona(Race race);

	public void atualiza(Race race);

	public List<Race> lista();

	public Race busca(Long id);

	public List<Race> buscaPelaDescricao(String description);

	public Race busca(String race);
}
