package br.eti.asneto.blog.mock;

import org.apache.commons.lang.RandomStringUtils;

import br.eti.asneto.blog.dao.BlogDAO;
import br.eti.asneto.blog.dao.OwnerDAO;
import br.eti.asneto.blog.dao.PostDAO;
import br.eti.asneto.blog.dao.util.BlogEntityManager;
import br.eti.asneto.blog.entity.Blog;
import br.eti.asneto.blog.entity.Owner;
import br.eti.asneto.blog.entity.Post;

public class PopulateDataBase {

	private BlogEntityManager entityManager = new BlogEntityManager();

	private Owner createOwner() {
		Owner user = new Owner("User Name " + RandomStringUtils.randomNumeric(1), RandomStringUtils.randomNumeric(1) + "user@asneto.eti.br", RandomStringUtils.randomNumeric(5));
		
		OwnerDAO ownerDAO = new OwnerDAO(entityManager.getEntityManager());
		ownerDAO.save(user);
		
		return user;
	}
	
	public Blog createBlog() {
		Blog blog = new Blog(createOwner(), "ASNeto Blog " + RandomStringUtils.randomNumeric(1));
		
		BlogDAO blogDAO = new BlogDAO(entityManager.getEntityManager());
		blogDAO.save(blog);
		
		return blog;
	}
	
	public Post createPost(Blog blog) {
		Post post = new Post(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(100), blog);
		
		PostDAO postDAO = new PostDAO(entityManager.getEntityManager());
		postDAO.save(post);
		
		return post;
	}
	
	public static void main(String[] args) {
		PopulateDataBase populate = new PopulateDataBase();
		populate.entityManager.beginTransaction();
		
		Blog blog = populate.createBlog();
		populate.createPost(blog);
		populate.createPost(blog);
		populate.createPost(blog);
		populate.createPost(blog);
		
		Blog otherBlog = populate.createBlog();
		populate.createPost(otherBlog);
		populate.createPost(otherBlog);
		populate.createPost(otherBlog);
		populate.createPost(otherBlog);
		
		populate.entityManager.commit();
		populate.entityManager.close();
	}
	
}
