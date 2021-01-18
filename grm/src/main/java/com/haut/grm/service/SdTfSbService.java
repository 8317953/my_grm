package com.haut.grm.service;

import java.util.List;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.haut.grm.datatables.repository.SdTfSbDataTablesRepository;
import com.haut.grm.model.SdTfSb;
import com.haut.grm.repository.SdTfSbRepository;

/**
 * @Description 通风设备状态的增删改查
 * @author fuq
 * @Date 2021/1/16 9点3分
 */
@Service
public class SdTfSbService {

	@Autowired
	private SdTfSbRepository tfsbRepo;
	
	@Autowired
	private SdTfSbDataTablesRepository tfsbtableRepo;
	
	/**
	* @method getAllTfSb(获取所有通风设备的状态)
	* @return List<SdTfSb>（获取一个通风设备的List集合）
	* @author fuq
	* @date 2021/1/16 9点3分
	*/
	public List<SdTfSb> getAllTfSb(){
		
		return tfsbRepo.findAll();
	}
	
	/**
	* @method saveSdTfSb(添加通风设备信息)
	* @param 通风设备实体
	* @return SdTfSb（通风设备实体对象）
	* @author fuq
	* @date 2021/1/16 9点3分
	*/
	public SdTfSb saveSdTfSb(SdTfSb sdtfsb) {
		
		return tfsbRepo.save(sdtfsb);
	}
	
	/**
	* @method getAllSdTfSb(获取所有通风设备)
	* @return DataTablesOutput<SdTfEquipStatus>（获取一个通风设备的DataTablesOutput集合）
	* @author fuq
	* @date 2021/1/16 9点3分
	*/
	public DataTablesOutput<SdTfSb> getAllSdTfSb(DataTablesInput input){
		
		return tfsbtableRepo.findAll(input);
	}
	
	/**
	* @method delsdTfSb(删除通风设备信息)
	* @param id
	* @author fuq
	* @date 2021/1/16 9点3分
	*/
	public void delSdTfSb(Long id) {
		
		tfsbRepo.delete(id);
	}
	
	/**
	* @method updSdTfSb(修改通风设备信息)
	* @param 通风设备实体
	* @author fuq
	* @date 2021/1/16 9点3分
	*/
	public SdTfSb updSdTfSb(SdTfSb sdtfsb) {
		
		return tfsbRepo.save(sdtfsb);
	}
}
