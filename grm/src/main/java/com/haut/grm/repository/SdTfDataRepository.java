
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QSdTfDate;
import com.haut.grm.model.SdTfDate;

import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface SdTfDataRepository extends BaseEntityRepository<SdTfDate,Long>, QueryDslPredicateExecutor<SdTfDate>, QuerydslBinderCustomizer<QSdTfDate> {
    default void customize(QuerydslBindings bindings, QSdTfDate sdTfDate) { /* compiled code */ }

    public List<SdTfDate> findByStore_Depot_Id(Long depotId);
    
    List<SdTfDate> findByCodeLike(String code);
     
}