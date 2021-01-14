
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.base;

@org.springframework.data.repository.NoRepositoryBean
public interface BaseTypeRepository <T extends com.haut.grm.model.base.AbstractType> extends com.haut.grm.repository.base.BaseEntityRepository<T,java.lang.Long> {
    T findByCodeId(java.lang.Integer integer);

    T findByName(java.lang.String s);

    T findByNameContaining(java.lang.String s);
}