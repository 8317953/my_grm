
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.MyDateJs;
import com.haut.grm.model.QMyDateJs;
import com.haut.grm.repository.base.BaseEntityRepository;

import io.swagger.annotations.Api;


@RepositoryRestResource
public interface MyDateJsRepository extends BaseEntityRepository<MyDateJs,String>, QueryDslPredicateExecutor<MyDateJs>, QuerydslBinderCustomizer<QMyDateJs> {
    default void customize(QuerydslBindings bindings, QMyDateJs myDateJs) { /* compiled code */ }

}