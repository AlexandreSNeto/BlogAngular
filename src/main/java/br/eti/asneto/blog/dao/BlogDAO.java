package br.eti.asneto.blog.dao;

import javax.persistence.EntityManager;

import br.eti.asneto.blog.dao.util.GenericDAO;
import br.eti.asneto.blog.entity.Blog;

public class BlogDAO extends GenericDAO<Long, Blog> {

	public BlogDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
