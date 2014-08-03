package br.eti.asneto.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.eti.asneto.blog.dao.util.GenericDAO;
import br.eti.asneto.blog.dao.util.QueryBuilder;
import br.eti.asneto.blog.entity.Post;

public class PostDAO extends GenericDAO<Long, Post>{

	public PostDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public List<Post> listAllPublicated(Long blogId) {
		QueryBuilder builder = new QueryBuilder();
		
		builder.concat("SELECT p")
			   .concat("FROM Post p")
			   .concat("WHERE p.published = :published", "published", Boolean.TRUE)
			   .concat("AND p.blog.id = :blogId", "blogId", blogId)
			   .concat("ORDER BY p.date DESC");
		
		return list(builder);
	}
	
	
}
