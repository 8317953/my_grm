package com.haut.grm.repository.business;


import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.haut.grm.model.business.QStockAggSum;

import com.haut.grm.model.business.StockAggSum;

import com.haut.grm.repository.base.BaseQRepository;



@RepositoryRestResource
public abstract interface StockAggSumRepository
  extends BaseQRepository<StockAggSum, String, QStockAggSum>
{}