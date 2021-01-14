package com.haut.grm.datatables.repository;




import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

import com.haut.grm.model.MyDateJs;

public abstract interface MyDateJsDataTablesRepository
  extends QDataTablesRepository<MyDateJs, String>
{}

