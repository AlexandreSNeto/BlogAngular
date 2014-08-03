package br.eti.asneto.blog.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;
import br.eti.asneto.blog.entity.Post;

public class EntityManagerIllustrationTest extends TestCase {
	private EntityManagerFactory entityManagerFactory;

	@Override
	protected void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("blog-pu");
	}

	@Override
	protected void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	public void testBasicUsage() {
		// create a couple of events...
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		//entityManager.persist(new Post("Our very first Post!", "Post content here", new Date()));
		//entityManager.persist(new Post("Our second Post!", "Post content here", new Date()));
		entityManager.getTransaction().commit();
		entityManager.close();

		// now lets pull events from the database and list them
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
        List<Post> result = entityManager.createQuery("from Post", Post.class).getResultList();
		for (Post event : result ) {
			System.out.println("Event (" + event.getDate() + ") : " + event.getTitle());
		}
        entityManager.getTransaction().commit();
        entityManager.close();
	}
}
