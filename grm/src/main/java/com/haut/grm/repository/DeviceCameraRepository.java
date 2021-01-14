
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;

import io.swagger.annotations.Api;


@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface DeviceCameraRepository extends com.haut.grm.repository.base.BaseQRepository<com.haut.grm.model.DeviceCamera,java.lang.Long,com.haut.grm.model.QDeviceCamera> {
    java.util.Set<com.haut.grm.model.DeviceCamera> findByType_CodeId(@org.springframework.data.repository.query.Param("typeCodeId") java.lang.Integer integer);

    java.util.Set<com.haut.grm.model.DeviceCamera> findByStore_Depot_IdOrStoreIsNull(@org.springframework.data.repository.query.Param("depotId") java.lang.Long aLong);

    @org.springframework.data.jpa.repository.Query("select c from #{#entityName} c LEFT JOIN c.store s where (s.depot.id = :depotId or s IS NULL) and c.type.codeId = :typeCodeId")
    java.util.Set<com.haut.grm.model.DeviceCamera> queryCamera(@org.springframework.data.repository.query.Param("depotId") java.lang.Long aLong, @org.springframework.data.repository.query.Param("typeCodeId") java.lang.Integer integer);

    @org.springframework.data.jpa.repository.Query("select c from #{#entityName} c LEFT JOIN c.store s where (s.depot.id = :depotId or s IS NULL) and c.type.codeId != :typeCodeId")
    java.util.Set<com.haut.grm.model.DeviceCamera> queryCameraForRegister(@org.springframework.data.repository.query.Param("depotId") java.lang.Long aLong, @org.springframework.data.repository.query.Param("typeCodeId") java.lang.Integer integer);

    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.QDeviceCamera root) { /* compiled code */ }
}