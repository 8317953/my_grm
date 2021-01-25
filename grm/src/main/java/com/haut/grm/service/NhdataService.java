package com.haut.grm.service;

import com.haut.grm.datatables.repository.NhdataDataTablesRepository;

import com.haut.grm.model.QNhdata;

import com.haut.grm.model.Nhdata;


import com.haut.grm.repository.NhdataRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class NhdataService
{
	
	@Autowired
	private NhdataRepository nhdataRepo;
		

	@Autowired
	private NhdataDataTablesRepository nhdataDatableRepo;
	
	
	public List<Nhdata> getAllNhdatas(){
		return nhdataRepo.findAll();
	}
	
	public Nhdata saveNhdata(Nhdata nhdata) {
		return nhdataRepo.save(nhdata);
	}
	
	
	
	public DataTablesOutput<Nhdata> getAllNhdataTable(DataTablesInput input){
		return nhdataDatableRepo.findAll(input);
	}
	
	
	
	public Nhdata getNhdataById(Long nhdataId) {
		return nhdataRepo.findOne(nhdataId);
	}
	
	
	public void deleteNhdataById(Long nhdataId) {
		nhdataRepo.delete(nhdataId);
	}
	
    //codeid*Integer,
	public Nhdata getNhdataByCodeid(Integer codeid) {
		return nhdataRepo.findByCodeid(codeid);
	}
	
    //code*String,s
	public List<Nhdata> getNhdataByCode(String code) {
		return nhdataRepo.findByCode(code);
	}
	
	
	public List<Nhdata> getNhdataByLikeCode(String code) {
		return nhdataRepo.findByCodeLike("%"+code+"%");
	}
    //end

}
