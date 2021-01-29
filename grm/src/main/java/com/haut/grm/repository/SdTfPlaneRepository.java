
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.haut.grm.model.QSdTfPlane;
import com.haut.grm.model.SdTfPlane;
import com.haut.grm.model.entry.EntryTemperature;
import com.haut.grm.repository.base.BaseEntityRepository;



@RepositoryRestResource
public interface SdTfPlaneRepository extends BaseEntityRepository<SdTfPlane,Long>, QueryDslPredicateExecutor<SdTfPlane>, QuerydslBinderCustomizer<QSdTfPlane> {
    default void customize(QuerydslBindings bindings, QSdTfPlane sdTfPlane) { /* compiled code */ }

    
    public List<SdTfPlane> findByDepot_Id(Long depotId);
    
    
    List<SdTfPlane> findByCodeLike(String code);
    
    
//    SELECT c.*  FROM sd_tf_plane_entry AS a INNER JOIN  grm_store AS b ON a.store_id=b.id INNER JOIN sd_tf_plane AS c ON a.tf_plane_id=c.id WHERE a.`store_id`=229
    
    @Query(value="SELECT c.*  FROM sd_tf_plane_entry AS a INNER JOIN  grm_store AS b ON a.store_id=b.id INNER JOIN sd_tf_plane AS c ON a.tf_plane_id=c.id WHERE a.`store_id`=?1", nativeQuery=true)
    public abstract List<SdTfPlane> findByStore_Id(Long store_id);
    
    
    
    
    
    
     
}