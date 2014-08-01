package br.eti.asneto.blog.dao.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<PK, ENTITY> {

	private EntityManager entityManager;
	 
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @SuppressWarnings("unchecked")
	public ENTITY getById(PK pk) {
        return (ENTITY) entityManager.find(getTypeClass(), pk);
    }
 
    public void save(ENTITY entity) {
        entityManager.persist(entity);
    }
 
    public void update(ENTITY entity) {
        entityManager.merge(entity);
    }
 
    public void delete(ENTITY entity) {
        entityManager.remove(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<ENTITY> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
	
}
