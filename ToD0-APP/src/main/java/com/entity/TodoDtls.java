package com.entity;

public class TodoDtls {
	private int id;
	private String t_name;
	private String t_todo;
	private String t_status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return t_name;
	}
	public void setName(String t_name) {
		this.t_name = t_name;
	}
	public String getTodo() {
		return t_todo;
	}
	public void setTodo(String t_todo) {
		this.t_todo = t_todo;
	}
	public String getStatus() {
		return t_status;
	}
	public void setStatus(String t_status) {
		this.t_status = t_status;
	}
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + t_name + ", todo=" + t_todo + ", status=" + t_status + "]";
	}
	
	
}
