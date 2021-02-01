package com.haut.grm.datatables.repository;


import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

import com.haut.grm.model.Qtfmmodel;

public abstract interface QtfmmodelDataTablesRepository
  extends QDataTablesRepository<Qtfmmodel, Long>
{}