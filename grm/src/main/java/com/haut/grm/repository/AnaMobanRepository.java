
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

import com.haut.grm.model.AnaMoban;

import com.haut.grm.model.QAnaMoban;
import com.haut.grm.model.business.Contract;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface AnaMobanRepository extends BaseEntityRepository<AnaMoban,Long>, QueryDslPredicateExecutor<AnaMoban>, QuerydslBinderCustomizer<QAnaMoban> {
    default void customize(QuerydslBindings bindings, QAnaMoban anaMoban) { /* compiled code */ }

    @Query("select entity from #{#entityName} entity where entity.gv.name like %:query%")
    List<AnaMoban> queryLike(@Param("query") String s);
    
    
    
    AnaMoban findTop1ByGv_NameOrderByIdDesc(String name);
}