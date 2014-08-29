package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.User;

public interface PetShopDao {

	public void adiciona(PetShop petShop);

	public void atualiza(PetShop petShop);

	public List<PetShop> lista();

	public PetShop busca(Long id);

	public PetShop buscaPeloDocument(String document);
	
	public PetShop buscaUserId(Long id);

	public PetShop busca(User loggedUser);
}
