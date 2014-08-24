package br.com.usjt.tcc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "petshop")
public class PetShop extends Company {

//	@OneToMany
//	private List<Product> products;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="petShop", fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
