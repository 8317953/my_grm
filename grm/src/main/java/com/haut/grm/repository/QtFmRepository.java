package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QQtFm;
import com.haut.grm.model.QtFm;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface QtFmRepository extends BaseEntityRepository<QtFm,Long>, QueryDslPredicateExecutor<QtFm>, QuerydslBinderCustomizer<QQtFm> {
    default void customize(QuerydslBindings bindings, QQtFm obj) { /* compiled code */ }

     
}