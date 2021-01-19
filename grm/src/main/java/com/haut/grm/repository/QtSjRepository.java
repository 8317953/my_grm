package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QQtSj;
import com.haut.grm.model.QtSj;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface QtSjRepository extends BaseEntityRepository<QtSj,Long>, QueryDslPredicateExecutor<QtSj>, QuerydslBinderCustomizer<QQtSj> {
    default void customize(QuerydslBindings bindings, QQtSj obj) { /* compiled code */ }

     
}