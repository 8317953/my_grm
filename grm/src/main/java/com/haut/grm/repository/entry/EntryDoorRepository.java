
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.entry;

@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface EntryDoorRepository extends com.haut.grm.repository.base.BaseEntryRepository<com.haut.grm.model.entry.EntryDoor>, org.springframework.data.querydsl.QueryDslPredicateExecutor<com.haut.grm.model.entry.EntryDoor>, org.springframework.data.querydsl.binding.QuerydslBinderCustomizer<com.haut.grm.model.entry.QEntryDoor> {
    java.util.List<com.haut.grm.model.entry.EntryDoor> findByDoor(com.haut.grm.model.Door door);

    java.util.List<com.haut.grm.model.entry.EntryDoor> findByDoorNotNullOrderByTimeDesc();

    java.util.List<com.haut.grm.model.entry.EntryDoor> findByDoor_Store_Id(java.lang.Long aLong);

    java.util.List<com.haut.grm.model.entry.EntryDoor> findByTimeGreaterThanAndDoorNotNullOrderByTimeDesc(java.util.Date date);

    long countByDoor_Store_Id(java.lang.Long aLong);

    com.haut.grm.model.entry.EntryDoor findTop1ByDoor_Store_IdOrderByTimeDesc(java.lang.Long aLong);

    java.util.List<com.haut.grm.model.entry.EntryDoor> findTop6ByDoorNotNullOrderByTimeDesc();

    long countByDoor_Store_IdAndTimeGreaterThanOrderByTimeDesc(java.lang.Long aLong, java.util.Date date);

    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.entry.QEntryDoor ed) { /* compiled code */ }
}