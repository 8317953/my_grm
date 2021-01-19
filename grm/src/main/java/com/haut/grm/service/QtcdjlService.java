package com.haut.grm.service;

import com.haut.grm.datatables.repository.QtcdjlDataTablesRepository;

import com.haut.grm.model.QQtcdjl;

import com.haut.grm.model.Qtcdjl;


import com.haut.grm.repository.QtcdjlRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class QtcdjlService
{
	
	@Autowired
	private QtcdjlRepository qtcdjlRepo;
		

	@Autowired
	private QtcdjlDataTablesRepository qtcdjlDatableRepo;
	
	
	public List<Qtcdjl> getAllQtcdjls(){
		return qtcdjlRepo.findAll();
	}
	
	public Qtcdjl saveQtcdjl(Qtcdjl qtcdjl) {
		return qtcdjlRepo.save(qtcdjl);
	}
	
	
	
	public DataTablesOutput<Qtcdjl> getAllQtcdjlTable(DataTablesInput input){
		return qtcdjlDatableRepo.findAll(input);
	}
	
	
	
	public Qtcdjl getQtcdjlById(Long qtcdjlId) {
		return qtcdjlRepo.findOne(qtcdjlId);
	}
	
	
	public void deleteQtcdjlById(Long qtcdjlId) {
		qtcdjlRepo.delete(qtcdjlId);
	}
	
}