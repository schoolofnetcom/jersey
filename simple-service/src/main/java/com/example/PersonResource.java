package com.example;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

@Path("person")
public class PersonResource {
	
	private Session session = HibernateSession.getSessionFactory().openSession();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonEntity> find() {
		List<PersonEntity> people = session.createQuery("from PersonEntity").getResultList();
		
		return people;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public PersonEntity findOne(@PathParam("id") Integer id) {
		return session.find(PersonEntity.class, id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person create(Person person) {		
		session.beginTransaction();
		
		PersonEntity personEntity = new PersonEntity(person.getName(), person.getLastname(), person.getAge());
		session.save(personEntity);
		
		session.getTransaction().commit();
		
		session.getSessionFactory().close();
		return person;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public PersonEntity update(@PathParam("id") Integer id, Person person) {
		session.beginTransaction();
			
		PersonEntity personEntity = session.find(PersonEntity.class, id);
		
		personEntity.setAge(person.getAge());
		personEntity.setName(person.getName());
		personEntity.setLastname(person.getLastname());
		
		session.save(personEntity);
		
		session.getTransaction().commit();
		
		session.getSessionFactory().close();
		
		return personEntity;
	}
	
	@DELETE
	@Path("{id}")
	public Boolean delete(@PathParam("id") Integer id) {
		session.beginTransaction();
		
		PersonEntity personEntity = session.find(PersonEntity.class, id);
		
		if (personEntity == null) {
			return false;
		}
		
		session.delete(personEntity);
		
		session.getTransaction().commit();
		
		session.getSessionFactory().close();
		
		return true;
	}
}
