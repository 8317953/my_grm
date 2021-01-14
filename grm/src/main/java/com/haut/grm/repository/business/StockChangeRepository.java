
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.repository.business;

import java.util.List;

import com.haut.grm.model.business.StockChange;

@org.springframework.data.rest.core.annotation.RepositoryRestResource
public interface StockChangeRepository extends com.haut.grm.repository.base.BaseBusinessRepository<com.haut.grm.model.business.StockChange,com.haut.grm.model.business.QStockChange> {
    java.util.List<com.haut.grm.model.business.StockChange> findByInputTimeLessThanEqualAndInputTimeGreaterThanAndSourceStock(java.util.Date date, java.util.Date date1, com.haut.grm.model.business.StockId stockId);

    java.util.List<com.haut.grm.model.business.StockChange> findByInputTimeLessThanEqualAndInputTimeGreaterThanAndTargetStock(java.util.Date date, java.util.Date date1, com.haut.grm.model.business.StockId stockId);

    
    public List<StockChange> findBySourceStock_Id(Long id);
    
    
    default void customize(org.springframework.data.querydsl.binding.QuerydslBindings bindings, com.haut.grm.model.business.QStockChange stockChange) { /* compiled code */ }
}