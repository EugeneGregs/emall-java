package com.gregs.mall.emall.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int id;
	
	@Column(nullable = false, name = "role_name")
	private String roleName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(
			name = "role_id",
			referencedColumnName = "role_id"),
	inverseJoinColumns = @JoinColumn(
			name = "user_id",
			referencedColumnName = "user_id"
			))
	@JsonIgnoreProperties({"roles","password"})
	private List<User> users;

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Role() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
