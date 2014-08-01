package br.eti.asneto.blog.service.test;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.eti.asneto.blog.business.PostService;
import br.eti.asneto.blog.entity.Post;

public class PostServiceTest {

	private PostService postService = new PostService();

	@Test
	public void testSave() {
		Post newPost = new Post("test", "test", new Date());
		postService.save(newPost);
		Assert.assertNotNull(newPost.getId());
		
		List<Post> allPosts = postService.listAll();
		Assert.assertFalse(allPosts.isEmpty());
		postService.finishJob();
	}

}
