package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QStoreConfig;
import com.haut.grm.model.StoreConfig;
import com.haut.grm.repository.base.BaseEntityRepository;

@RepositoryRestResource
public interface StoreConfigRepository extends BaseEntityRepository<StoreConfig,Long>, QueryDslPredicateExecutor<StoreConfig>, QuerydslBinderCustomizer<QStoreConfig> {
	default void customize(QuerydslBindings bindings, QStoreConfig storeConfig) { /* compiled code */ }//多继承必须写这个函数 但是 看到其他几个接口 也有少继承的情况
}
