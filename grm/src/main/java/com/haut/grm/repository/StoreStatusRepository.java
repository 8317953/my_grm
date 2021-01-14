package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QStoreStatus;
import com.haut.grm.model.StoreStatus;
import com.haut.grm.repository.base.BaseEntityRepository;

import io.swagger.annotations.Api;


@RepositoryRestResource
public interface StoreStatusRepository extends BaseEntityRepository<StoreStatus,Long>, QueryDslPredicateExecutor<StoreStatus>, QuerydslBinderCustomizer<QStoreStatus> {
	default void customize(QuerydslBindings bindings, QStoreStatus storeStatus) { /* compiled code */ }//多继承必须写这个函数 但是 看到其他几个接口 也有少继承的情况
}
