package br.eti.asneto.blog.dao.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericDAO<PK extends Serializable, ENTITY> {

	private EntityManager entityManager;
	 
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
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
    public ENTITY find(PK pk) {
    	return (ENTITY) entityManager.find(getTypeClass(), pk);
    }
 
    @SuppressWarnings("unchecked")
    public List<ENTITY> findAll() {
        return getQuery(("FROM " + getTypeClass().getName())).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<ENTITY> list(QueryBuilder queryBuilder) {
    	return getQuery(queryBuilder).getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<ENTITY> list(QueryBuilder queryBuilder, int init, int max) {
    	return getQuery(queryBuilder).setFirstResult(init).setMaxResults(max).getResultList();
    }
    
    private Query getQuery(QueryBuilder queryBuilder) {
    	Query query = getQuery(queryBuilder.buildQuery());
    	if (queryBuilder.hasParameters()) {
    		Iterator<Entry<String, Object>> it = queryBuilder.buildParameters().entrySet().iterator();
    		while (it.hasNext()) {
    			Map.Entry<String, Object> pairs = (Map.Entry<String, Object>)it.next();
    			query.setParameter(pairs.getKey(), pairs.getValue());
    		}
    	}
    	return query;
    }
    
    private Query getQuery(String query) {
    	return entityManager.createQuery(query);
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
	
}
