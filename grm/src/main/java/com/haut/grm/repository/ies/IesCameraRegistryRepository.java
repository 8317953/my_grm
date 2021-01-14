
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.ies;

@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface IesCameraRegistryRepository extends com.haut.grm.repository.base.BaseQRepository<com.haut.grm.model.ies.IesCameraRegistry,java.lang.Long,com.haut.grm.model.ies.QIesCameraRegistry> {
    java.util.List<com.haut.grm.model.ies.IesCameraRegistry> findByTrafficModule_Code(java.lang.String s);

    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.ies.QIesCameraRegistry data) { /* compiled code */ }
}