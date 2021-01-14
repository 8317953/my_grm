package com.haut.grm.service;



import com.haut.grm.datatables.repository.SdTfDataDataTablesRepository;
import com.haut.grm.datatables.repository.SdTfPlaneDataTablesRepository;
import com.haut.grm.model.QSdTfDate;
import com.haut.grm.model.QSdTfPlane;
import com.haut.grm.model.SdTfDate;
import com.haut.grm.model.SdTfPlane;

import com.haut.grm.repository.SdTfDataRepository;
import com.haut.grm.repository.SdTfPlaneRepository;
import com.haut.grm.repository.StorePerTemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class SdTFService
{
	@Autowired
	private StorePerTemRepository tfEntryRepo;
	
	@Autowired
	private SdTfPlaneRepository sdtfplaneRepo;
		
	@Autowired
	private SdTfDataRepository tfDataRepo;
	
	@Autowired
	private SdTfPlaneDataTablesRepository sdtfplanetableRepo;
	
	@Autowired
	private SdTfDataDataTablesRepository sdtfdatatableRepo;
	
	public List<SdTfPlane> getAllTfPlanes(Long depotId){
		if(depotId==null) {
			return sdtfplaneRepo.findAll();
		}else {
			return sdtfplaneRepo.findByDepot_Id(depotId);
		}
		
	}
	
	public SdTfPlane saveSdTfPlane(SdTfPlane tfplane) {
		return sdtfplaneRepo.save(tfplane);
	}
	
	public void saveSdTfData(SdTfDate sdTfData) {
		tfDataRepo.save(sdTfData);
	}
	
	public List<SdTfDate> getAllTfDates(Long depotId){
		if(depotId==null) {
			return tfDataRepo.findAll();
		}else {
			return tfDataRepo.findByStore_Depot_Id(depotId);
		}
		
	}
	
	
	public DataTablesOutput<SdTfPlane> getAllSdTfPlaneTable(DataTablesInput input,Long depotId){
		QSdTfPlane qed=QSdTfPlane.sdTfPlane;

		return depotId!=null? sdtfplanetableRepo.findAll(input,qed.depot.id.eq(depotId)):sdtfplanetableRepo.findAll(input);
	}
	
	public DataTablesOutput<SdTfDate> getAllSdTfDataTable(DataTablesInput input,Long depotId){
		QSdTfDate qed=QSdTfDate.sdTfDate;
		return depotId!=null? sdtfdatatableRepo.findAll(input,qed.store.depot.id.eq(depotId)):sdtfdatatableRepo.findAll(input);
	}
	
	
	public List<SdTfPlane> getSdTfPlanesByCodeLike(String code){
		return sdtfplaneRepo.findByCodeLike("%"+code+"%");
	}
	
	public List<SdTfDate> getSdTfDatesByCodeLike(String code){
		return tfDataRepo.findByCodeLike("%"+code+"%");
	}
	
	public SdTfPlane getSdTfPlaneById(Long tfplId) {
		return sdtfplaneRepo.findOne(tfplId);
	}
	
	
	public void deleteSdTfPlaneById(Long tfplId) {
		sdtfplaneRepo.delete(tfplId);
	}
	
	
	public SdTfDate getSdTfDataById(Long id) {
		return tfDataRepo.findOne(id);
	}
	
	public void deleteSdTfDataById(Long id) {
		tfDataRepo.delete(id);
	}
	
	
}
