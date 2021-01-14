package com.haut.grm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.grm.model.AnaMoban;
import com.haut.grm.model.Plane;
import com.haut.grm.model.type.AnaBzType;
import com.haut.grm.model.wenzhou.OutInLetter;
import com.haut.grm.repository.AnaMobanRepository;
import com.haut.grm.repository.PlaneRepository;
import com.haut.grm.repository.type.AnaBzTypeRepository;
import com.haut.grm.repository.wenzhou.OutInLetterRepository;

@Service
public class PlaneService {

	@Autowired
	AnaBzTypeRepository anaBzRepo;
	
	@Autowired
	private PlaneRepository planeRepo;
	
	@Autowired
	private OutInLetterRepository oiletterRepo;
	
	@Autowired
	private AnaMobanRepository anaMobanRepo;

	
	public void savePlane(Plane plane) {
		planeRepo.save(plane);
	}
	
	
	
	public void saveLetter(OutInLetter oil) {
		oiletterRepo.save(oil);
	}
	
	
	public void updatePlane(Plane plane) {
		if(plane.getId()==null) {
			System.out.println("修改计划数据失败 没有Id");
			return;
		}
		planeRepo.save(plane);
	}
	
	
	public void updateOutInLetter(OutInLetter oil) {
		if(oil.getId()==null) {
			System.out.println("修改出入库通知单失败 没有id");
			return;
		}
		oiletterRepo.save(oil);
	}
	
	
	public void deletePlane(Long id) {
		planeRepo.delete(id);
	}
	
	
	public Plane getPlaneById(Long id) {
		return planeRepo.findOne(id);
	}
	
	public OutInLetter getLetterById(Long id) {
		return oiletterRepo.findOne(id);
	}
	
	public void deleteLetter(Long id) {
		oiletterRepo.delete(id);
	}
	
	
	public List<AnaBzType> getAllAnaBzTypes(){
		return anaBzRepo.findAll();
	}
	
	
	public void deleteZbByName(String name) {
		anaBzRepo.deleteByName(name);
	}
	
	public List<AnaMoban>  getAnaMobanLikeName(String name) {
		return anaMobanRepo.queryLike(name);
	}
	
	public AnaMoban getAnaMobanByGvName(String name) {
		return anaMobanRepo.findTop1ByGv_NameOrderByIdDesc(name);
	}
	
	public AnaBzType findBzTypeByName(String name) {
		return anaBzRepo.findByName(name);
	}
	
	public AnaBzType saveAnaBzType(AnaBzType a) {
		return anaBzRepo.save(a);
	}
	
	public AnaMoban saveAnaMoban(AnaMoban a) {
		return anaMobanRepo.save(a);
	}
	
}
