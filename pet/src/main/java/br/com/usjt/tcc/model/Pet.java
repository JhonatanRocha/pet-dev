package br.com.usjt.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.usjt.tcc.enun.Size;

@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Size size;
	private String deficiency;

	@OneToOne
	private Type type;
	@OneToOne
	private Race race;
	@OneToOne
	private Color color;

	@Column(columnDefinition = "CHAR(1)")
	private String gender;

	private Boolean isDeficient;
	private Boolean isCastrated;
	private String picturePath;

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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getDeficiency() {
		return deficiency;
	}

	public void setDeficiency(String deficiency) {
		this.deficiency = deficiency;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIsDeficient() {
		return isDeficient;
	}

	public void setIsDeficient(Boolean isDeficient) {
		this.isDeficient = isDeficient;
	}

	public Boolean getIsCastrated() {
		return isCastrated;
	}

	public void setIsCastrated(Boolean isCastrated) {
		this.isCastrated = isCastrated;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}
