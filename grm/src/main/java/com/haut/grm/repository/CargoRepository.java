
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.Cargo;
import com.haut.grm.model.QCargo;

import io.swagger.annotations.Api;


@RepositoryRestResource
public interface CargoRepository extends com.haut.grm.repository.base.BaseEntityRepository<Cargo,Long>, QueryDslPredicateExecutor<com.haut.grm.model.Cargo>, QuerydslBinderCustomizer<QCargo> {
    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.QCargo cargo) { /* compiled code */ }

    java.util.List<com.haut.grm.model.Cargo> findByCompartment_Store_Depot_Id(long l);

    long countByCompartment_Store_Id(long l);
}