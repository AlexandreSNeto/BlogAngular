package br.eti.asneto.blog.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.cache.NoCache;

import br.eti.asneto.blog.business.PostService;
import br.eti.asneto.blog.entity.Post;

@NoCache
@Path("/posts")
@Produces("application/json")
public class PostResource {
	
	private PostService postService = new PostService();
	
	@GET
	@Path("/list/{blogId}")
	public List<Post> listAllPublicated(@PathParam("blogId") Long blogId) {
		return postService.listAllPublicated(blogId);
	}
	
	@POST
	@Path("/add/{blogId}")
	public Post add(Post post) {
		return postService.save(post);
	}

}
