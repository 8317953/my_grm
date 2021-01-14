
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.entry;

@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface EntrySafetyRepository extends com.haut.grm.repository.base.BaseEntryRepository<com.haut.grm.model.entry.EntrySafety>, org.springframework.data.querydsl.QueryDslPredicateExecutor<com.haut.grm.model.entry.EntrySafety>, org.springframework.data.querydsl.binding.QuerydslBinderCustomizer<com.haut.grm.model.entry.QEntrySafety> {
    java.util.List<com.haut.grm.model.entry.EntrySafety> findByStore(com.haut.grm.model.Store store);

    java.util.List<com.haut.grm.model.entry.EntrySafety> findByStore_IdOrderByTimeDesc(java.lang.Long aLong);

    long countByStore_Id(java.lang.Long aLong);

    long countByStore_IdAndActive(java.lang.Long aLong, java.lang.Boolean aBoolean);

    java.util.List<com.haut.grm.model.entry.EntrySafety> findByActiveAndStoreNotNull(boolean b);

    java.util.List<com.haut.grm.model.entry.EntrySafety> findTop6ByStoreNotNullOrderByTimeDesc();

    com.haut.grm.model.entry.EntrySafety findTop1ByStore_IdOrderByTimeDesc(java.lang.Long aLong);

    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.entry.QEntrySafety es) { /* compiled code */ }
}