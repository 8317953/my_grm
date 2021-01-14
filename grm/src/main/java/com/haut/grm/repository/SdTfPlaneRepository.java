
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QSdTfPlane;
import com.haut.grm.model.SdTfPlane;

import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface SdTfPlaneRepository extends BaseEntityRepository<SdTfPlane,Long>, QueryDslPredicateExecutor<SdTfPlane>, QuerydslBinderCustomizer<QSdTfPlane> {
    default void customize(QuerydslBindings bindings, QSdTfPlane sdTfPlane) { /* compiled code */ }

    
    public List<SdTfPlane> findByDepot_Id(Long depotId);
    
    
    List<SdTfPlane> findByCodeLike(String code);
     
}