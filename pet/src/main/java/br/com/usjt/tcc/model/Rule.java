package br.com.usjt.tcc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rule")
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	private Boolean type;
	private Boolean race;
	private Boolean stage;
	private Boolean size;
	private Boolean score;

	@OneToOne
	private Product product;

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

	public Boolean getRace() {
		return race;
	}

	public void setRace(Boolean race) {
		this.race = race;
	}

	public Boolean getStage() {
		return stage;
	}

	public void setStage(Boolean stage) {
		this.stage = stage;
	}

	public Boolean getSize() {
		return size;
	}

	public void setSize(Boolean size) {
		this.size = size;
	}

	public Boolean getScore() {
		return score;
	}

	public void setScore(Boolean score) {
		this.score = score;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

}
