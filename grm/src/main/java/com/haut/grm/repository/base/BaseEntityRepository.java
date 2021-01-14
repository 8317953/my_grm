
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.base;

@org.springframework.data.repository.NoRepositoryBean
public interface BaseEntityRepository <T extends com.haut.grm.model.base.AbstractEntity<PK>, PK extends java.io.Serializable> extends org.springframework.data.jpa.repository.JpaRepository<T,PK> {
    @org.springframework.data.jpa.repository.Query("select entity from #{#entityName} entity")
    java.util.List<T> listAll();
}