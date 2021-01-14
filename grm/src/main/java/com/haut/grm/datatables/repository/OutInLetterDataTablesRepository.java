package com.haut.grm.datatables.repository;


import com.haut.grm.model.wenzhou.OutInLetter;

import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

public abstract interface OutInLetterDataTablesRepository
  extends QDataTablesRepository<OutInLetter, Long>
{}
