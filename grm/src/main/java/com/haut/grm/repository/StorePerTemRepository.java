
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;




import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QStorePerTemWater;
import com.haut.grm.model.StorePerTemWater;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface StorePerTemRepository extends BaseEntityRepository<StorePerTemWater,Long>, QueryDslPredicateExecutor<StorePerTemWater>, QuerydslBinderCustomizer<QStorePerTemWater> {
    default void customize(QuerydslBindings bindings, QStorePerTemWater sdTfPlane) { /* compiled code */ }

    
}