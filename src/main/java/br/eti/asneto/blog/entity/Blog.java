package br.eti.asneto.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.eti.asneto.blog.entity.util.EntityAbstract;

@Entity
public class Blog extends EntityAbstract {

	private static final long serialVersionUID = 1454396112532465619L;

	@NotNull
	@ManyToOne
	private Owner owner;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

	public Blog() {
		super();
	}

	public Blog(Owner owner, String name) {
		super();
		this.owner = owner;
		this.name = name;
	}
	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
