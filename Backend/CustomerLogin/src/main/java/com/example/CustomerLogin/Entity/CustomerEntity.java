package com.example.CustomerLogin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Will add properties and column names for our table that we will create in MySql

@Entity
@Data
@Table(name = "Customer" , uniqueConstraints = {@UniqueConstraint(columnNames = {"password"})})
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PASSWORD")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
