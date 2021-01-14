
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.MyQingjia;
import com.haut.grm.model.QMyQingjia;
import com.haut.grm.repository.base.BaseEntityRepository;


@RepositoryRestResource
public interface QingjiaRepository extends BaseEntityRepository<MyQingjia,Long>, QueryDslPredicateExecutor<QMyQingjia> {
    
}