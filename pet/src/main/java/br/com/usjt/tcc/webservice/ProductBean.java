package br.com.usjt.tcc.webservice;

import java.math.BigDecimal;

public class ProductBean {

	private String name;
	private String typeOfPet;
	private String race;
	private String stage;
	private String sizeOfPet;
	private int score;
	private BigDecimal price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfPet() {
		return typeOfPet;
	}
	public void setTypeOfPet(String typeOfPet) {
		this.typeOfPet = typeOfPet;
	}
	public String getRaca() {
		return race;
	}
	public void setRaca(String raca) {
		this.race = raca;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getSizeOfPet() {
		return sizeOfPet;
	}
	public void setSizeOfPet(String sizeOfPet) {
		this.sizeOfPet = sizeOfPet;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
