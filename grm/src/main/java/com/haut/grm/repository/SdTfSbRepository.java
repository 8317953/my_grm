
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QSdTfSb;
import com.haut.grm.model.SdTfSb;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface SdTfSbRepository extends BaseEntityRepository<SdTfSb,Long>, QueryDslPredicateExecutor<SdTfSb>, QuerydslBinderCustomizer<QSdTfSb> {
    default void customize(QuerydslBindings bindings, QSdTfSb sdTfSb) { /* compiled code */ }
    
}