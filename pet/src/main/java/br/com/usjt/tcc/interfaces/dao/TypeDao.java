package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Type;

public interface TypeDao {

	public void adiciona(Type type);

	public void atualiza(Type type);

	public List<Type> lista();

	public Type busca(Long id);

	public Type busca(String type);
}
