package com.boydlever.onetomanydemo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min = 5, max = 200, message="Please make username 2 character or more!")
	private String userName;
	
	@Email
	private String email;
	
	// ONE TO MANY
	@OneToMany(mappedBy="donor", fetch = FetchType.LAZY)
	private List<Donation> donatedItems; //joined donations
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Donation> getDonatedItems() {
		return donatedItems;
	}

	public void setDonatedItems(List<Donation> donatedItems) {
		this.donatedItems = donatedItems;
	}
	
}
