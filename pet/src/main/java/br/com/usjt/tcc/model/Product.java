package br.com.usjt.tcc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.usjt.tcc.enun.Size;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@OneToOne
	private Type typeOfPet;
	@OneToOne
	private Race raca;
	private String stage;

	private Size sizeOfPet;
	private int score;
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getTypeOfPet() {
		return typeOfPet;
	}

	public void setTypeOfPet(Type typeOfPet) {
		this.typeOfPet = typeOfPet;
	}

	public Race getRaca() {
		return raca;
	}

	public void setRaca(Race raca) {
		this.raca = raca;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Size getSizeOfPet() {
		return sizeOfPet;
	}

	public void setSizeOfPet(Size sizeOfPet) {
		this.sizeOfPet = sizeOfPet;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
