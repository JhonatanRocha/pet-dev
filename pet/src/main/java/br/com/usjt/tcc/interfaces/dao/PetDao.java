package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Pet;

public interface PetDao {

	public void adiciona(Pet pet);

	public void atualiza(Pet pet);

	public List<Pet> lista();

	public Pet busca(Long id);
}
