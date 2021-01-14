package com.haut.grm.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.Mydebug;

import com.haut.grm.model.QMydebug;
import com.haut.grm.repository.base.BaseEntityRepository;

@RepositoryRestResource
public interface MydebugRepository extends BaseEntityRepository<Mydebug,Long>, QueryDslPredicateExecutor<Mydebug>, QuerydslBinderCustomizer<QMydebug> {
	default void customize(QuerydslBindings bindings, QMydebug mydebug) { /* compiled code */ }//多继承必须写这个函数 但是 看到其他几个接口 也有少继承的情况
}
