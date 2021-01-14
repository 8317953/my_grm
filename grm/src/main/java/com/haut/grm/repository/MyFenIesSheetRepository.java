
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.MyFenIesSheet;
import com.haut.grm.model.QMyFenIesSheet;
import com.haut.grm.model.business.StockId;
import com.haut.grm.repository.base.BaseEntityRepository;

//import io.swagger.annotations.Api;


@RepositoryRestResource
public interface MyFenIesSheetRepository extends BaseEntityRepository<MyFenIesSheet,String>, QueryDslPredicateExecutor<MyFenIesSheet>, QuerydslBinderCustomizer<QMyFenIesSheet> {
    default void customize(QuerydslBindings bindings, QMyFenIesSheet myFenIesSheet) { /* compiled code */ }
    
    public List<MyFenIesSheet> findByStockAndOuttimeBefore(StockId stock,Date date);
}