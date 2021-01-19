package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QQtCdModel;
import com.haut.grm.model.QtCdModel;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface QtCdModelRepository extends BaseEntityRepository<QtCdModel,Long>, QueryDslPredicateExecutor<QtCdModel>, QuerydslBinderCustomizer<QQtCdModel> {
    default void customize(QuerydslBindings bindings, QQtCdModel obj) { /* compiled code */ }

     
}