package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Product;

public interface ProductDao {

	public void adiciona(Product product);

	public void atualiza(Product product);

	public List<Product> lista();

	public Product busca(Long id);
}
