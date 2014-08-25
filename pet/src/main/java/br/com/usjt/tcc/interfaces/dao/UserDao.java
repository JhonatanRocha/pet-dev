package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.User;

public interface UserDao {

	public void adiciona(User user);
	public void atualiza(User user);
	public List<User> lista();
	public User busca(Long id);
	public User buscaPeloEmail(String email);
	public boolean buscaUserEmail(String email);
	public boolean existeUser(User user);
}
