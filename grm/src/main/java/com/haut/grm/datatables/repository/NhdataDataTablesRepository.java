package com.haut.grm.datatables.repository;


import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

import com.haut.grm.model.Nhdata;

public abstract interface NhdataDataTablesRepository
  extends QDataTablesRepository<Nhdata, Long>
{}