package com.apm.threshold.resource;

import org.restlet.ext.wadl.WadlServerResource;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class RegisterResource extends WadlServerResource{
	@Get
	public Representation method1() throws ResourceException {
		return new StringRepresentation("Register Success! Get Method");
	}

	@Post
	public Representation method2(Representation entity)  
			throws ResourceException {
		String result = getRequest().getEntityAsText();
		System.out.println(result);
		return new StringRepresentation("Register Success! Post Method");
	}
}
