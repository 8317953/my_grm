
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.base;

@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface BusinessDataRepository extends com.haut.grm.repository.base.BaseEntityRepository<com.haut.grm.model.business.BusinessData,java.lang.Long> {
    com.haut.grm.model.business.BusinessData findByBusinessKey(@org.springframework.data.repository.query.Param("businessKey") java.lang.String s);
}