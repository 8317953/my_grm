
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.ies;

@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface IesCameraImageRepository extends com.haut.grm.repository.base.BaseQRepository<com.haut.grm.model.ies.IesCameraImage,java.lang.Long,com.haut.grm.model.ies.QIesCameraImage> {
    java.util.List<com.haut.grm.model.ies.IesCameraImage> findByGrainTraffic_Id(Long aLong);

    java.util.List<com.haut.grm.model.ies.IesCameraImage> findByGrainTrafficIdAndRegistry_TrafficModule_Code(java.lang.Long aLong, java.lang.String s);

    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.ies.QIesCameraImage data) { /* compiled code */ }
}