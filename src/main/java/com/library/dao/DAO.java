package com.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mgil on 4/13/17.
 */
public abstract  class DAO <T>{

//    @PersistenceUnit(unitName = "ServerPU")
//    private EntityManagerFactory emFactory;

    @PersistenceContext(name = "ServerPU")
    private EntityManager entityManager;

    Class<T> entityClass;

    public DAO(Class<T> entityClass) {
        this.entityClass = entityClass;

        Map<String,String> emConfig = new HashMap<String, String>();

//        entityManager = emFactory.createEntityManager(emConfig);

    }

    public List<T> findAll(){
        List<T> entities = entityManager.createNamedQuery(entityClass.getSimpleName() +".findAll",entityClass).getResultList();
        return entities;
    }

    public void create(T entity){

        if(entity == null)
            throw new IllegalArgumentException("The entity cannot be null");
        entityManager.persist(entity);
    }

}
