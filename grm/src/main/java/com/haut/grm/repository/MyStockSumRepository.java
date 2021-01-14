
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QMyStockSum;
import com.haut.grm.model.MyStockSum;
import com.haut.grm.repository.base.BaseEntityRepository;

import io.swagger.annotations.Api;


@RepositoryRestResource
public interface MyStockSumRepository extends BaseEntityRepository<MyStockSum,Long>, QueryDslPredicateExecutor<MyStockSum>, QuerydslBinderCustomizer<QMyStockSum> {
    default void customize(QuerydslBindings bindings, QMyStockSum untilEntryTem) { /* compiled code */ }

   
}