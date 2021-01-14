
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.base;

import java.util.List;

@org.springframework.data.repository.NoRepositoryBean
public interface BaseBusinessRepository <T extends com.haut.grm.model.base.AbstractBusiness, K extends com.querydsl.core.types.dsl.EntityPathBase<T>> extends com.haut.grm.repository.base.BaseQRepository<T,java.lang.Long,K> {
    T findByBusinessKey(java.lang.String s);

    T findByBusinessKeyContaining(java.lang.String s);
    
    List<T> findByBusinessKeyLike(String key);
}