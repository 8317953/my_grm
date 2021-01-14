
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface StoreRepository extends com.haut.grm.repository.base.BaseEntityRepository<com.haut.grm.model.Store,java.lang.Long>, org.springframework.data.querydsl.QueryDslPredicateExecutor<com.haut.grm.model.Store>, org.springframework.data.querydsl.binding.QuerydslBinderCustomizer<com.haut.grm.model.QStore> {
    java.util.List<com.haut.grm.model.Store> findByStatus_IsMeasureOngoing(boolean b);

    com.haut.grm.model.Store findByDepot_IdAndCodeId(java.lang.Long aLong, java.lang.Integer integer);

    java.util.List<com.haut.grm.model.Store> findByDepot_Id(java.lang.Long aLong);

    @org.springframework.data.jpa.repository.EntityGraph(attributePaths = {"doors"})
    java.util.List<com.haut.grm.model.Store> getByDepot_Id(java.lang.Long aLong);

    @org.springframework.data.jpa.repository.EntityGraph(attributePaths = {"doors"})
    com.haut.grm.model.Store getById(java.lang.Long aLong);

    @org.springframework.data.jpa.repository.EntityGraph(attributePaths = {"doors"})
    java.util.List<com.haut.grm.model.Store> getDistinctByIdNotNullOrderByCodeIdAsc();

    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.QStore store) { /* compiled code */ }
}