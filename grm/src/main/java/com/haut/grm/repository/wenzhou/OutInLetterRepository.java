package com.haut.grm.repository.wenzhou;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.wenzhou.OutInLetter;
import com.haut.grm.model.wenzhou.QOutInLetter;
import com.haut.grm.repository.base.BaseEntityRepository;

@RepositoryRestResource
public interface OutInLetterRepository extends BaseEntityRepository<OutInLetter,Long>, QueryDslPredicateExecutor<OutInLetter>, QuerydslBinderCustomizer<QOutInLetter>  {
	default void customize(QuerydslBindings bindings, QOutInLetter outInLetter) { /* compiled code */ }
}
