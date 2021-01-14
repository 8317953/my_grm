
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.base;

@org.springframework.data.repository.NoRepositoryBean
public interface BaseQRepository <T extends com.haut.grm.model.base.AbstractEntity<PK>, PK extends java.io.Serializable, K extends com.querydsl.core.types.dsl.EntityPathBase<T>> extends com.haut.grm.repository.base.BaseEntityRepository<T,PK>, org.springframework.data.querydsl.QueryDslPredicateExecutor<T>, org.springframework.data.querydsl.binding.QuerydslBinderCustomizer<K> {
    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, K root) { /* compiled code */ }
}