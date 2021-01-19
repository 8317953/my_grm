package com.haut.grm.datatables.repository;


import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

import com.haut.grm.model.Qtcdjl;

public abstract interface QtcdjlDataTablesRepository
  extends QDataTablesRepository<Qtcdjl, Long>
{}