package com.haut.grm.service;

import com.haut.grm.datatables.repository.QtSjDataTablesRepository;

import com.haut.grm.model.QQtSj;

import com.haut.grm.model.QtSj;


import com.haut.grm.repository.QtSjRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class QtSjService
{
	
	@Autowired
	private QtSjRepository qtsjRepo;
		

	@Autowired
	private QtSjDataTablesRepository qtsjDatableRepo;
	
	
	public List<QtSj> getAllQtSjs(){
		return qtsjRepo.findAll();
	}
	
	public QtSj saveQtSj(QtSj qtsj) {
		return qtsjRepo.save(qtsj);
	}
	
	
	
	public DataTablesOutput<QtSj> getAllQtSjTable(DataTablesInput input){
		return qtsjDatableRepo.findAll(input);
	}
	
	
	
	public QtSj getQtSjById(Long qtsjId) {
		return qtsjRepo.findOne(qtsjId);
	}
	
	
	public void deleteQtSjById(Long qtsjId) {
		qtsjRepo.delete(qtsjId);
	}




    //store.id*Long,
	public QtSj getQtSjByStore_Id(Long store_id) {
		return qtsjRepo.findByStore_Id(store_id);
	}
	

    //code*String,
	public QtSj getQtSjByCode(String code) {
		return qtsjRepo.findByCode(code);
	}
	
	
	public List<QtSj> getQtSjByLikeCode(String code) {
		return qtsjRepo.findByCodeLike("%"+code+"%");
	}    //codeId*Integer,
	public QtSj getQtSjByCodeId(Integer codeid) {
		return qtsjRepo.findByCodeId(codeid);
	}
	

    //end




}
