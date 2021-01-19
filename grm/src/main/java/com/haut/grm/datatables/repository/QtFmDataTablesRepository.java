package com.haut.grm.datatables.repository;


import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

import com.haut.grm.model.QtFm;

public abstract interface QtFmDataTablesRepository
  extends QDataTablesRepository<QtFm, Long>
{}