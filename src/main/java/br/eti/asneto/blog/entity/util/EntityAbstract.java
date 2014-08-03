package br.eti.asneto.blog.entity.util;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.google.common.base.Objects;

@MappedSuperclass
public abstract class EntityAbstract implements Serializable {

	private static final long serialVersionUID = 4387030014081585904L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		EntityAbstract other = (EntityAbstract) obj;
		return Objects.equal(this.id, other.id);
	}
	
}
