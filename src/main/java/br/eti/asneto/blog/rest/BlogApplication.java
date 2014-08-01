package br.eti.asneto.blog.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class BlogApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public BlogApplication() {
		singletons.add(new PostResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
