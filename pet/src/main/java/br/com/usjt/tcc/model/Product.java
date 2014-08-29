package br.com.usjt.tcc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@OneToOne
	private Type type;
	@OneToOne
	private Race race;
	private String stage;

	private String size;
	private int score;
	private Double price;

	@JoinColumn(name="petShop_id", referencedColumnName = "id")
	@ManyToOne
	private PetShop petShop;
	
	private String linkPhoto;
	private String linkAnuncio;
	
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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

	public PetShop getPetShop() {
		return petShop;
	}

	public void setPetShop(PetShop petShop) {
		this.petShop = petShop;
	}

	public String getLinkPhoto() {
		return linkPhoto;
	}

	public void setLinkPhoto(String linkPhoto) {
		this.linkPhoto = linkPhoto;
	}

	public String getLinkAnuncio() {
		return linkAnuncio;
	}

	public void setLinkAnuncio(String linkAnuncio) {
		this.linkAnuncio = linkAnuncio;
	}

}
