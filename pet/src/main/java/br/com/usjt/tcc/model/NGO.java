package br.com.usjt.tcc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ngo")
public class NGO extends Company {

	@OneToMany(cascade=CascadeType.ALL, mappedBy="ngo", fetch = FetchType.EAGER)
	private List<Pet> pets = new ArrayList<Pet>();
	
	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
