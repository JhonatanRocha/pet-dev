package br.com.usjt.tcc.model;

public class ProductVO {

	private String name;
	private String type;
	private String race;
	private String stage;
	private String size;
	private Integer score;
	private Double price;
	private String linkPhoto;
	private String linkAnuncio;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
