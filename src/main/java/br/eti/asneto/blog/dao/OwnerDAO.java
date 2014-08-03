package br.eti.asneto.blog.dao;

import javax.persistence.EntityManager;

import br.eti.asneto.blog.dao.util.GenericDAO;
import br.eti.asneto.blog.entity.Owner;

public class OwnerDAO extends GenericDAO<Long, Owner> {

	public OwnerDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
