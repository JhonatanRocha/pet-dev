package br.com.usjt.tcc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.model.Product;

public class JDBCProductDao implements ProductDao {

	private Connection connection;

	public JDBCProductDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void adiciona(Product product) {

		String query = "insert into product "
				+ "(name,price,score,sizeOfPet,stage,raca_id,typeOfPet_id)"
				+ " VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);

			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setLong(3, product.getScore());
			stmt.setString(4, product.getSizeOfPet());
			stmt.setString(5, product.getStage());
			stmt.setLong(6, product.getRaca().getId());
			stmt.setLong(7, product.getTypeOfPet().getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void atualiza(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product busca(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
