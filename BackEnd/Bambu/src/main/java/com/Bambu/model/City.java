package com.Bambu.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class City implements Serializable{
	private static final long serialVersionUID = 5519954706545385693L;
	String name;

	public City(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
