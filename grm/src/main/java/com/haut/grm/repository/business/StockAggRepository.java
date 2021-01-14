package com.haut.grm.repository.business;


import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.haut.grm.model.business.QStockAgg;

import com.haut.grm.model.business.StockAgg;

import com.haut.grm.repository.base.BaseQRepository;




@RepositoryRestResource
public abstract interface StockAggRepository
  extends BaseQRepository<StockAgg, String, QStockAgg>
{}