package br.eti.asneto.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.eti.asneto.blog.entity.util.EntityAbstract;

@Entity
public class Post extends EntityAbstract {

	private static final long serialVersionUID = 4811607688586319467L;
	
	@NotNull
	@ManyToOne
	private Blog blog;
	
	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "content")
	private String content;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	
	@Column(name = "published")
	private boolean published;

	public Post() {
		super();
	}

	public Post(String title, String content, Blog blog) {
		super();
		this.title = title;
		this.content = content;
		this.date = new Date();
		this.blog = blog;
		this.published = Boolean.TRUE;
	}

	public Post(String title, String content, Date date, Blog blog) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.blog = blog;
		this.published = Boolean.TRUE;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

}
