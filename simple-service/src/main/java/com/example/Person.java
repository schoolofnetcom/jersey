package com.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private Integer id;
	private String name;
	private String lastname;
	private Integer age;
	
	
	public Person() {
		
	}
	
	public Person(Integer id, String name, String lastname, Integer age) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
	}
	
	@XmlElement
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}	
	
	@XmlElement
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getLastname() {
		return this.lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@XmlElement
	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
}
