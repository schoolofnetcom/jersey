package com.example;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class SetHeader implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
		System.out.println("Hello this is my filter");
		responseContext.getHeaders().add("Custom-Header", "School of net");		
	}
}
