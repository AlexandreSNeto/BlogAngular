package br.eti.asneto.blog.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.eti.asneto.blog.business.PostService;
import br.eti.asneto.blog.entity.Post;

@Path("/posts")
@Produces("application/json")
public class PostResource {
	
	private PostService postService = new PostService();
	
	@GET
	@Path("/list")
	public List<Post> listAll() {
		return postService.listAll();
	}

}
