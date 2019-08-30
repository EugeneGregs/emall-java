package com.gregs.mall.emall.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(nullable = false, name = "first_name")
	private String firstName;
	@Column(nullable = false, name = "last_name")
	private String lastName;
	@Column(nullable = false, name = "user_email")
	private String userEmail;
	@Column(nullable = false, name = "password")
	@JsonIgnore
	private String password;
	@Column(nullable = false, name = "phone")
	private String phone;
	@Column(nullable = false, name = "postal_address")
	private String postalAddress;
	@Column(nullable = false, name = "zip_code")
	private String zipCode;
	@Column(nullable = false, name = "country")
	private String country;
	@Column(nullable = false, name = "state")
	private String state;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
	@JsonIgnoreProperties("users")
	private List<Role> roles;
			
	public User() {
	}

	public User(String firstName, String lastName, String userEmail, String password, String phone,
			String postalAddress, String zipCode, String country, String state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.password = password;
		this.phone = phone;
		this.postalAddress = postalAddress;
		this.zipCode = zipCode;
		this.country = country;
		this.state = state;
	}
	
	public List<String> getAuthorities() {
		List<String> authorieStrings = new ArrayList<String>();
		this.roles.forEach(r -> {
			authorieStrings.add(r.getRoleName());
		});
		return authorieStrings;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail=" + userEmail
				+ ", password=" + password + ", phone=" + phone + ", postalAddress=" + postalAddress + ", zipCode="
				+ zipCode + ", country=" + country + ", state=" + state + "]";
	}
	
}
