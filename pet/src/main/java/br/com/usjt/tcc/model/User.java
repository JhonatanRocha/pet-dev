package br.com.usjt.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;
	private String password;

	@Column(columnDefinition = "VARCHAR(20)")
	private String phone;
	@Column(columnDefinition = "VARCHAR(20)")
	private String cellphone;

	@OneToOne
	private Address address;
	private Boolean isOwner = false;
	private Boolean isOfNGO = false;
	private Boolean isOfPetShop = false;
	private Boolean isActivated = true;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}

	public Boolean getIsOfNGO() {
		return isOfNGO;
	}

	public void setIsOfNGO(Boolean isOfNGO) {
		this.isOfNGO = isOfNGO;
	}

	public Boolean getIsOfPetShop() {
		return isOfPetShop;
	}

	public void setIsOfPetShop(Boolean isOfPetShop) {
		this.isOfPetShop = isOfPetShop;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
}
