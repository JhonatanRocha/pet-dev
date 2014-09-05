package br.com.usjt.tcc.interfaces.dao;

import java.util.List;

import br.com.usjt.tcc.model.Announcement;

public interface AnnouncementDao {

	public void adiciona(Announcement announcement);

	public void atualiza(Announcement announcement);

	public List<Announcement> lista();

	public Announcement busca(Long id);

}
