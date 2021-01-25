package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QNhdata;
import com.haut.grm.model.Nhdata;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface NhdataRepository extends BaseEntityRepository<Nhdata,Long>, QueryDslPredicateExecutor<Nhdata>, QuerydslBinderCustomizer<QNhdata> {
    default void customize(QuerydslBindings bindings, QNhdata obj) { /* compiled code */ }

    //codeid*Integer,
    
    Nhdata findByCodeid(Integer codeid);
     
    //code*String,s
    
    List<Nhdata> findByCodeLike(String code);
     
    
    List<Nhdata> findByCode(String code);
     

    //end


}
