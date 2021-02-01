package com.haut.grm.service;

import com.haut.grm.datatables.repository.QtCdModelDataTablesRepository;

import com.haut.grm.model.QQtCdModel;

import com.haut.grm.model.QtCdModel;


import com.haut.grm.repository.QtCdModelRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class QtCdModelService
{
	
	@Autowired
	private QtCdModelRepository qtcdmodelRepo;
		

	@Autowired
	private QtCdModelDataTablesRepository qtcdmodelDatableRepo;
	
	
	public List<QtCdModel> getAllQtCdModels(){
		return qtcdmodelRepo.findAll();
	}
	
	public QtCdModel saveQtCdModel(QtCdModel qtcdmodel) {
		return qtcdmodelRepo.save(qtcdmodel);
	}
	
	
	
	public DataTablesOutput<QtCdModel> getAllQtCdModelTable(DataTablesInput input){
		return qtcdmodelDatableRepo.findAll(input);
	}
	
	
	
	public QtCdModel getQtCdModelById(Long qtcdmodelId) {
		return qtcdmodelRepo.findOne(qtcdmodelId);
	}
	
	
	public void deleteQtCdModelById(Long qtcdmodelId) {
		qtcdmodelRepo.delete(qtcdmodelId);
	}
    //store.id*Long,s
	public List<QtCdModel> getQtCdModelByStore_Id(Long store_id) {
		return qtcdmodelRepo.findByStore_Id(store_id);
	}
	

    //end

}
