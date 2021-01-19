package com.haut.grm.service;

import com.haut.grm.datatables.repository.QtFmDataTablesRepository;

import com.haut.grm.model.QQtFm;

import com.haut.grm.model.QtFm;


import com.haut.grm.repository.QtFmRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class QtFmService
{
	
	@Autowired
	private QtFmRepository qtfmRepo;
		

	@Autowired
	private QtFmDataTablesRepository qtfmDatableRepo;
	
	
	public List<QtFm> getAllQtFms(){
		return qtfmRepo.findAll();
	}
	
	public QtFm saveQtFm(QtFm qtfm) {
		return qtfmRepo.save(qtfm);
	}
	
	
	
	public DataTablesOutput<QtFm> getAllQtFmTable(DataTablesInput input){
		return qtfmDatableRepo.findAll(input);
	}
	
	
	
	public QtFm getQtFmById(Long qtfmId) {
		return qtfmRepo.findOne(qtfmId);
	}
	
	
	public void deleteQtFmById(Long qtfmId) {
		qtfmRepo.delete(qtfmId);
	}
	
}