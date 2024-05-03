package com.entity;

public class UserDtls {
	private int id;
	private String name;
	private String email;
	private String password;
	private String contact;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String contact) {
		this.password = contact;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", Email=" + email + ", password=" + password + ",contact="+ contact+"]";
	}
	

}
