package br.com.usjt.tcc.interfaces.dao;

import java.util.List;
import br.com.usjt.tcc.model.Color;

public interface ColorDao {

	public void adiciona(Color color);

	public void atualiza(Color color);

	public List<Color> lista();

	public Color busca(Long id);

	public List<Color> buscaPelaDescricao(String description);
}
