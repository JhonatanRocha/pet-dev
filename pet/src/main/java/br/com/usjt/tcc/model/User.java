package br.com.usjt.tcc.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	@Temporal(TemporalType.DATE)
	private Calendar birth;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Pet> pets = new ArrayList<Pet>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Announcement> announcement = new ArrayList<Announcement>();

	// @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	// private List<Pet> pets;

	private int score;

	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;
	private Boolean isOfNGO = false;
	private Boolean isOfPetShop = false;
	private Boolean isActivated = true;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Voucher> vouchers = new ArrayList<Voucher>();

	public byte[] getFoto() {
		return photo;
	}

	public void setFoto(byte[] foto) {
		this.photo = foto;
	}

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

	public Calendar getBirth() {
		return birth;
	}

	public void setBirth(Calendar birth) {
		this.birth = birth;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Announcement> getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(List<Announcement> announcement) {
		this.announcement = announcement;
	}

	public List<Voucher> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}
}
