
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class RestRepositoryConfigurer extends org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter {
    public RestRepositoryConfigurer() { /* compiled code */ }
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void configureRepositoryRestConfiguration(org.springframework.data.rest.core.config.RepositoryRestConfiguration config) { 

    	config.setBasePath("/api");
    	config.setDefaultPageSize(9999);//设置默认数量
//    	config.exposeIdsFor(TJobConf.class);
    	
    	
    	//设置显示ID
    	List<Class<?>> entityClasses = getAllManagedEntityTypes();
        for (Class<?> entityClass : entityClasses) {
            config.exposeIdsFor(entityClass);
        }
    
    }
    
    
    
    private List<Class<?>> getAllManagedEntityTypes() {
        List<Class<?>> entityClasses = new ArrayList<>();
        Metamodel metamodel = entityManagerFactory.getMetamodel();
        for (ManagedType<?> managedType : metamodel.getManagedTypes()) {
            Class<?> javaType = managedType.getJavaType();
            if (javaType.isAnnotationPresent(Entity.class)) {
                entityClasses.add(managedType.getJavaType());
            }
        }
        return entityClasses;
    }
    
    
    

    public void configureJacksonObjectMapper(com.fasterxml.jackson.databind.ObjectMapper objectMapper) { /* compiled code */ }
}