
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QUntilEntryTem;
import com.haut.grm.model.UntilEntryTem;
import com.haut.grm.repository.base.BaseEntityRepository;

import io.swagger.annotations.Api;


@RepositoryRestResource
public interface UntilEntryTemRepository extends BaseEntityRepository<UntilEntryTem,Long>, QueryDslPredicateExecutor<UntilEntryTem>, QuerydslBinderCustomizer<QUntilEntryTem> {
    default void customize(QuerydslBindings bindings, com.haut.grm.model.QUntilEntryTem untilEntryTem) { /* compiled code */ }

    @Query(value="SELECT * FROM `my_entry_tem` WHERE (store_id=?1 AND TIME>?2) GROUP BY ymd ORDER BY ymd ASC", nativeQuery=true)
    public List<UntilEntryTem> findByStore_idAndTime(Long store_id,String date);
}