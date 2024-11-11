package com.example.CRUD.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection="employees")
public class Employee {
	
	@Id
    private String id;
    private String email_id;
    private String first_name;
    private String last_name;

    public Employee() {
	
    }
	 public Employee(String email_id, String first_name, String last_name) {
		super();
		this.email_id = email_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
	
}
