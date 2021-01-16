package com.haut.grm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.haut.grm.datatables.repository.SdTfEquipStatusDataTablesRepository;
import com.haut.grm.model.SdTfEquipStatus;
import com.haut.grm.repository.SdTfEquipStatusRepository;


/**
 * @Description 通风设备状态的增删改查
 * @author fuq
 * @Date 2021/1/15 14点45分
 */
@Service
public class SdTfEquipStatusService {

	@Autowired
	private SdTfEquipStatusRepository sdtfequipRepo;

	@Autowired
	private SdTfEquipStatusDataTablesRepository sdtfequiptableRepo;

	/**
	* @method getAllTfEquipStatus(获取所有通风设备的状态)
	* @return List<SdTfEquipStatus>（获取一个通风设备状态的List集合）
	* @author fuq
	* @date 2021/1/15 14点45分
	*/
	public List<SdTfEquipStatus> getAllTfEquipStatus() {
		
		return sdtfequipRepo.findAll();
	}
	
	
	
	/**
	* @method saveSdTfEquipStatus(添加通风设备状态信息)
	* @param 通风设备状态实体
	* @return SdTfEquipStatus（通风状态实体对象）
	* @author fuq
	* @date 2021/1/15 14点45分
	*/
	public SdTfEquipStatus saveSdTfEquipStatus(SdTfEquipStatus sdtfEquipStatus) {
		
		return sdtfequipRepo.save(sdtfEquipStatus);
	}
	
	
	
	/**
	* @method getAllTfEquipStatus(获取所有通风设备的状态)
	* @return DataTablesOutput<SdTfEquipStatus>（获取一个通风设备状态的DataTablesOutput集合）
	* @author fuq
	* @date 2021/1/15 14点45分
	*/
	public DataTablesOutput<SdTfEquipStatus> getAllSdTfEquipStatus(DataTablesInput input){
		
		return sdtfequiptableRepo.findAll(input);
	}
	
	/**
	* @method delTfEquipStatus(删除通风设备状态信息)
	* @param id
	* @author fuq
	* @date 2021/1/15 14点45分
	*/
	public void delSdTfEquipStatus(Long id) {
		sdtfequipRepo.delete(id);
	}
	
	/**
	* @method updTfEquipStatus(修改通风设备状态信息)
	* @param 通风设备实体
	* @author fuq
	* @date 2021/1/15 14点45分
	*/
    public SdTfEquipStatus updTfEquipStatus(SdTfEquipStatus sdtfEquipStatus) {
		
		return sdtfequipRepo.save(sdtfEquipStatus);
	}
}
