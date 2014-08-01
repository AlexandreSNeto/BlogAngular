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

	public void save(Post product) {
		try {
			entityManager.beginTransaction();
			dao.save(product);
			entityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.rollBack();
		}
	}

	public List<Post> listAll() {
		return dao.findAll();
	}
	
	public void finishJob() {
		entityManager.close();
	}

}
