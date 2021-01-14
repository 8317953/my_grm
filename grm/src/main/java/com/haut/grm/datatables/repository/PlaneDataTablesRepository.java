package com.haut.grm.datatables.repository;

import com.haut.grm.model.Plane;

import org.springframework.data.jpa.datatables.qrepository.QDataTablesRepository;

public abstract interface PlaneDataTablesRepository
  extends QDataTablesRepository<Plane, Long>
{}
