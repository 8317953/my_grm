
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.base;

@org.springframework.data.repository.NoRepositoryBean
public interface BaseEntryRepository <T extends com.haut.grm.model.base.AbstractEntry> extends com.haut.grm.repository.base.BaseEntityRepository<T,java.lang.Long> {
    T findByTimeBefore(java.util.Date date);

    T findByTimeAfter(java.util.Date date);
}