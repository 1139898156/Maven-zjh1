package com.ysd.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.modules;
import com.ysd.mapper.modulesMapper;
import com.ysd.service.modulesService;

@Service
public class modulesServiceImpl implements modulesService{
	@Autowired
	private modulesMapper modulesMapper;
	public List<modules> getAllModules() {
		// TODO Auto-generated method stub
		return modulesMapper.getAllModules();
	}

	public modules getModulesById(int Id) {
		// TODO Auto-generated method stub
		return modulesMapper.getModulesById(Id);
	}

	public int addModulesById(String Name, int ParentId, String Path, int Weight) {
		// TODO Auto-generated method stub
		return modulesMapper.addModulesById(Name, ParentId, Path, Weight);
	}

	public int udModulesById(int Id, String Name) {
		// TODO Auto-generated method stub
		return modulesMapper.udModulesById(Id, Name);
	}

	public int deleteModulesById(int Id) {
		// TODO Auto-generated method stub
		return modulesMapper.deleteModulesById(Id);
	}

	
	
}
