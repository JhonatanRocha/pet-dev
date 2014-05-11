package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Owner;

public interface OwnerDao {

	public void adiciona(Owner owner);

	public void atualiza(Owner owner);

	public List<Owner> lista();

	public Owner busca(Long id);

}
