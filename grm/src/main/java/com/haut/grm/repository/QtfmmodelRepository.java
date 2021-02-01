package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QQtfmmodel;
import com.haut.grm.model.Qtfmmodel;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface QtfmmodelRepository extends BaseEntityRepository<Qtfmmodel,Long>, QueryDslPredicateExecutor<Qtfmmodel>, QuerydslBinderCustomizer<QQtfmmodel> {
    default void customize(QuerydslBindings bindings, QQtfmmodel obj) { /* compiled code */ }

     
    //end
}