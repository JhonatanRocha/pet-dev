package br.com.usjt.tcc.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String size;
	private String deficiency;

	@OneToOne
	private Type type;
	@OneToOne
	private Race race;
	@OneToOne
	private Color color;

	@Column(columnDefinition = "CHAR(1)")
	private String gender;

	private Boolean isNeutered;
	private Boolean isDeficient;

	private String stage;
	private Boolean isActive;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private User user;

	@JoinColumn(name = "ngo_id", referencedColumnName = "id")
	@ManyToOne
	private NGO ngo;

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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

	public byte[] getFoto() {
		return photo;
	}

	public void setFoto(byte[] foto) {
		this.photo = foto;
	}

	public Boolean getIsNeutered() {
		return isNeutered;
	}

	public void setIsNeutered(Boolean isNeutered) {
		this.isNeutered = isNeutered;
	}

	public Boolean getIsDeficient() {
		return isDeficient;
	}

	public void setIsDeficient(Boolean isDeficient) {
		this.isDeficient = isDeficient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public NGO getNgo() {
		return ngo;
	}

	public void setNgo(NGO ngo) {
		this.ngo = ngo;
	}

}
