
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.base;

@org.springframework.data.repository.NoRepositoryBean
public interface BaseStandardCodeRepository <T extends com.haut.grm.model.base.AbstractStandardCode> extends com.haut.grm.repository.base.BaseEntityRepository<T,java.lang.Long> {
    @org.springframework.data.jpa.repository.Query("select entity from #{#entityName} entity where entity.code like %:code%")
    java.util.List<T> findByCodeContaining(@org.springframework.data.repository.query.Param("code") java.lang.String s);

    @org.springframework.data.jpa.repository.Query("select entity from #{#entityName} entity where entity.code like :code%")
    java.util.List<T> findByCodeStartingWith(@org.springframework.data.repository.query.Param("code") java.lang.String s);

    @org.springframework.data.jpa.repository.Query("select entity from #{#entityName} entity where entity.name like %:name%")
    java.util.List<T> findByNameContaining(@org.springframework.data.repository.query.Param("name") java.lang.String s);

    @org.springframework.data.jpa.repository.Query("select entity from #{#entityName} entity where entity.code like %:query% or entity.name like %:query%")
    java.util.List<T> queryLike(@org.springframework.data.repository.query.Param("query") java.lang.String s);

    T findByCode(@org.springframework.data.repository.query.Param("code") java.lang.String s);

    T findByShortCode(@org.springframework.data.repository.query.Param("shortCode") java.lang.String s);
}