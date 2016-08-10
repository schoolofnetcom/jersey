package com.example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("second")
public class SecondResource {
	
	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	public String second(@QueryParam("name") String name) {
		return "Second resource exposed " + name;
	}
	
	@POST
	@Produces(value = MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_JSON)
	public Person request(Person person) {
		return person; 
	}
}
