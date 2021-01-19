package com.haut.grm.datatables.repository;


import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

import com.haut.grm.model.QtSj;

public abstract interface QtSjDataTablesRepository
  extends QDataTablesRepository<QtSj, Long>
{}