package com.haut.grm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.haut.grm.datatables.repository.SdTfEquipStatusDataTablesRepository;
import com.haut.grm.model.SdTfEquipStatus;
import com.haut.grm.repository.SdTfEquipStatusRepository;


@Service
public class SdTfEquipStatusService {

	@Autowired
	private SdTfEquipStatusRepository sdtfequipRepo;

	@Autowired
	private SdTfEquipStatusDataTablesRepository sdtfequiptableRepo;
	
	public List<SdTfEquipStatus> getAllTfEquipStatus() {
		
		return sdtfequipRepo.findAll();
	}
	
	
	public SdTfEquipStatus saveSdTfEquipStatus(SdTfEquipStatus sdtfEquipStatus) {
		
		return sdtfequipRepo.save(sdtfEquipStatus);
	}
	
	
	public DataTablesOutput<SdTfEquipStatus> getAllSdTfEquipStatus(DataTablesInput input){
		
		return sdtfequiptableRepo.findAll(input);
	}
	
	public void delSdTfEquipStatus(Long id) {
		sdtfequipRepo.delete(id);
	}
	
    public SdTfEquipStatus getTfEquipStatusById(Long id) {
		
		return sdtfequipRepo.findOne(id);
	}
}
