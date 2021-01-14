package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.haut.grm.model.CargoRepView;

import com.haut.grm.model.QCargoRepView;
import com.haut.grm.repository.base.BaseEntityRepository;

import io.swagger.annotations.Api;


@RepositoryRestResource
public interface CargoRepRepository extends BaseEntityRepository<CargoRepView,Long>, QueryDslPredicateExecutor<CargoRepView>, QuerydslBinderCustomizer<QCargoRepView> {
    default void customize(QuerydslBindings bindings, QCargoRepView cargoRepView) { /* compiled code */ }

}