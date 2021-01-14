package com.haut.grm.service;


import com.haut.grm.datatables.repository.MyDateJsDataTablesRepository;
import com.haut.grm.datatables.repository.MyStockSumHistoryDataTablesRepository;
import com.haut.grm.datatables.repository.StockIdDataTablesRepository;
import com.haut.grm.datatables.repository.StockSumDataTablesRepository;
import com.haut.grm.model.MyDateJs;
import com.haut.grm.model.Plane;
import com.haut.grm.model.business.MyStockSumHistory;
import com.haut.grm.model.business.StockAnalysis;
import com.haut.grm.model.business.StockId;
import com.haut.grm.model.business.StockSum;
import com.haut.grm.model.ies.Analysis;
import com.haut.grm.repository.business.StockAnalysisRepository;
import com.haut.grm.repository.business.StockIdRepository;
import com.haut.grm.repository.business.StockSumRepository;
import com.haut.grm.repository.ies.AnalysisRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Service
public class StockIdService
{
	@Autowired
	private StockIdRepository stockRepo;
	
	@Autowired
	private StockAnalysisRepository stockAnaRepo;

	@Autowired
	private AnalysisRepository iesAnaRepo;
	
	
	@Autowired
	private StockIdDataTablesRepository stockDataRepo;
	
	@Autowired
	private StockSumDataTablesRepository stockDataSumRepo;
	
	@Autowired
	private MyStockSumHistoryDataTablesRepository myStockSumHisRepo;
	
	@Autowired
	private StockSumRepository stockSumRepo;
	
	@Autowired
	private MyDateJsDataTablesRepository myDateJsDataRepo;
	
	public StockId getStockIdById(Long id) {
		return stockRepo.findOne(id);
	}

	
	
	public void saveStockAna(StockAnalysis sa) {
		if(sa.getId()!=null) {
			System.out.println("有ID修改");
		}else {
			System.out.println("无ID新增");
		}
		stockAnaRepo.save(sa);
	}
	
	
	public List<StockAnalysis> findByBussinessKeyLike(String key){
		return stockAnaRepo.findByBusinessKeyLike("%"+key+"%");
	}
	
	
	public StockAnalysis findStockAnaById(Long id) {
		return stockAnaRepo.findOne(id);
	}
	
	public List<Analysis> findIesAnaLikeBarcode(String barcode){
		return iesAnaRepo.findByBarcodeLike("%"+barcode+"%");
	}
	
	public void saveIesAna(Analysis a) {
		iesAnaRepo.save(a);
	}
	
	
	public List<StockId> getAllStockId() {
		return stockRepo.findAll();
	}
	
	
	
	public DataTablesOutput<StockId> getAllDataStockId(DataTablesInput input){
		return stockDataRepo.findAll(input);
	}
	
	
	public DataTablesOutput<StockSum> getAllDataStockSum(DataTablesInput input){
		return stockDataSumRepo.findAll(input);
	}
	
	
	public void saveStockId(StockId stock){
		stockRepo.save(stock);
	}
	
	
	public List<StockId> findStockIdByBussinessKeyLike(String key){
		return stockRepo.findByBusinessKeyLike("%"+key+"%");
	}
	
	
	public DataTablesOutput<MyStockSumHistory> getAllMyStockSumHistoryData(DataTablesInput input){
		return myStockSumHisRepo.findAll(input);
	}
	
	
	public List<StockSum> getAllStockSumm(){
		return stockSumRepo.findAll();
	}
	
	
	
	public StockSum getStockSumByCargo_Id(Long id) {
		return stockSumRepo.findByCargo_Id(id);
	}
	
	public DataTablesOutput<MyDateJs> getAllMyDateJsData(DataTablesInput input){
		return myDateJsDataRepo.findAll(input);
	}
	
	
}
