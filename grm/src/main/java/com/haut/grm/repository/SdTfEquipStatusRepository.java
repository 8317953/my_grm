
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

import com.haut.grm.model.QSdTfEquipStatus;
import com.haut.grm.model.SdTfEquipStatus;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface SdTfEquipStatusRepository extends BaseEntityRepository<SdTfEquipStatus,Long>, QueryDslPredicateExecutor<SdTfEquipStatus>, QuerydslBinderCustomizer<QSdTfEquipStatus> {
    default void customize(QuerydslBindings bindings, QSdTfEquipStatus sdTfSb) { /* compiled code */ }

}