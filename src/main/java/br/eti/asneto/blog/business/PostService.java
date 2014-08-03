package br.eti.asneto.blog.business;

import java.util.List;

import br.eti.asneto.blog.dao.PostDAO;
import br.eti.asneto.blog.dao.util.BlogEntityManager;
import br.eti.asneto.blog.entity.Post;

public class PostService {

	private PostDAO dao;

	private BlogEntityManager entityManager;

	public PostService() {
		this.entityManager = new BlogEntityManager();
		dao = new PostDAO(entityManager.getEntityManager());
	}

	public Post save(Post post) {
		try {
			entityManager.beginTransaction();
			dao.save(post);
			entityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.rollBack();
		}
		return post;
	}

	public List<Post> listAllPublicated(Long blogId) {
		return dao.listAllPublicated(blogId);
	}
	
	public void finishJob() {
		entityManager.close();
	}

}
