package com.haut.grm.service;

import com.haut.grm.datatables.repository.QtfmmodelDataTablesRepository;

import com.haut.grm.model.QQtfmmodel;

import com.haut.grm.model.Qtfmmodel;


import com.haut.grm.repository.QtfmmodelRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class QtfmmodelService
{
	
	@Autowired
	private QtfmmodelRepository qtfmmodelRepo;
		

	@Autowired
	private QtfmmodelDataTablesRepository qtfmmodelDatableRepo;
	
	
	public List<Qtfmmodel> getAllQtfmmodels(){
		return qtfmmodelRepo.findAll();
	}
	
	public Qtfmmodel saveQtfmmodel(Qtfmmodel qtfmmodel) {
		return qtfmmodelRepo.save(qtfmmodel);
	}
	
	
	
	public DataTablesOutput<Qtfmmodel> getAllQtfmmodelTable(DataTablesInput input){
		return qtfmmodelDatableRepo.findAll(input);
	}
	
	
	
	public Qtfmmodel getQtfmmodelById(Long qtfmmodelId) {
		return qtfmmodelRepo.findOne(qtfmmodelId);
	}
	
	
	public void deleteQtfmmodelById(Long qtfmmodelId) {
		qtfmmodelRepo.delete(qtfmmodelId);
	}
	
    //end
}