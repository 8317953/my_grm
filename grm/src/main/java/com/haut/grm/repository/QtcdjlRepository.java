package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QQtcdjl;
import com.haut.grm.model.Qtcdjl;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface QtcdjlRepository extends BaseEntityRepository<Qtcdjl,Long>, QueryDslPredicateExecutor<Qtcdjl>, QuerydslBinderCustomizer<QQtcdjl> {
    default void customize(QuerydslBindings bindings, QQtcdjl obj) { /* compiled code */ }

     
}