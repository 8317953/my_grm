package com.haut.grm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.grm.model.type.PlanType;
import com.haut.grm.model.type.PlaneDwType;
import com.haut.grm.repository.type.PlanDwTypeRepository;
import com.haut.grm.repository.type.PlanTypeRepository;

@Service
public class TypeService
{
	@Autowired
	private PlanTypeRepository pTypeRepo;
	
	@Autowired
	private PlanDwTypeRepository dwTypeRepo;

	
	
	public List<PlanType> getAllPlaneType(){
		return pTypeRepo.findAll();
	}
	
	
	public List<PlaneDwType> getAllPDwType(){
		return dwTypeRepo.findAll();
	}
	
}


