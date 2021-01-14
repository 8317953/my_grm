
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.system;

@org.springframework.data.rest.core.annotation.RepositoryRestResource(collectionResourceRel = "trafficModules", itemResourceRel = "trafficModule", path = "trafficModules")
public interface SystemTrafficModuleRepository extends com.haut.grm.repository.base.BaseQRepository<com.haut.grm.model.system.SystemTrafficModule,java.lang.Long,com.haut.grm.model.system.QSystemTrafficModule> {
    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.system.QSystemTrafficModule data) { /* compiled code */ }
}