package com.haut.grm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.haut.grm.datatables.repository.SdTfSbDataTablesRepository;
import com.haut.grm.model.SdTfSb;
import com.haut.grm.repository.SdTfSbRepository;

@Service
public class SdTfSbService {

	@Autowired
	private SdTfSbRepository tfsbRepo;
	
	@Autowired
	private SdTfSbDataTablesRepository tfsbtableRepo;
	
	public List<SdTfSb> getAllTfSb(){
		
		return tfsbRepo.findAll();
	}
	
	public SdTfSb saveSdTfSb(SdTfSb sdtfsb) {
		
		return tfsbRepo.save(sdtfsb);
	}
	
	public DataTablesOutput<SdTfSb> getAllSdTfSb(DataTablesInput input){
		
		return tfsbtableRepo.findAll(input);
	}
	
	public void delSdTfSb(Long id) {
		
		tfsbRepo.delete(id);
	}
	
	public SdTfSb getSdTfSbById(Long id) {
		
		return tfsbRepo.findOne(id);
	}
	
}
