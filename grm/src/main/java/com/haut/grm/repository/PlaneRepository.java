
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.haut.grm.model.Plane;

import com.haut.grm.model.QPlane;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface PlaneRepository extends BaseEntityRepository<Plane,Long>, QueryDslPredicateExecutor<Plane>, QuerydslBinderCustomizer<QPlane> {
    default void customize(QuerydslBindings bindings, QPlane plane) { /* compiled code */ }

   
}