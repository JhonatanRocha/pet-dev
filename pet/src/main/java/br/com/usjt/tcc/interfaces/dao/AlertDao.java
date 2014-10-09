package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Alert;

public interface AlertDao {

	public void adiciona(Alert alert);

	public void atualiza(Alert alert);

	public List<Alert> lista();

	public Alert busca(Long id);

}
