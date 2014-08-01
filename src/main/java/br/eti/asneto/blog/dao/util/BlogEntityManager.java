package br.eti.asneto.blog.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class encapsulates some work of EntityManager and EntityManagerFactory,
 * doing only the essential
 * 
 * @author alexandre
 *
 */
public class BlogEntityManager {

	private EntityManager entityManager;

	private EntityManagerFactory factory;

	public BlogEntityManager() {
		factory = Persistence.createEntityManagerFactory("br.eti.asneto.blog");
		this.entityManager = factory.createEntityManager();
	}

	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	public void close() {
		entityManager.close();
		factory.close();
	}

	public void rollBack() {
		entityManager.getTransaction().rollback();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}