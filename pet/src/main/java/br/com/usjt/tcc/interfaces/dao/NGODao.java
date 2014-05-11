package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.NGO;

public interface NGODao {

	public void adiciona(NGO ngo);

	public void atualiza(NGO ngo);

	public List<NGO> lista();

	public NGO busca(Long id);

	public NGO buscaPeloDocument(String document);
}
