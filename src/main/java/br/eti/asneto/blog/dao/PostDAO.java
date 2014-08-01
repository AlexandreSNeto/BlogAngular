package br.eti.asneto.blog.dao;

import javax.persistence.EntityManager;

import br.eti.asneto.blog.dao.util.GenericDAO;
import br.eti.asneto.blog.entity.Post;

public class PostDAO extends GenericDAO<Long, Post>{

	public PostDAO(EntityManager entityManager) {
		super(entityManager);
	}
	

}
