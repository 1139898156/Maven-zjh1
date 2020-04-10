package com.ysd.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.modules;
import com.ysd.entity.roles;
import com.ysd.mapper.rolesMapper;
import com.ysd.service.rolesService;
@Service
@Transactional
public class rolesServiceImpl implements rolesService{
	@Autowired
	private rolesMapper rolesmapper;

	public List<roles> getRolesAll() {
		// TODO Auto-generated method stub
		return rolesmapper.getRolesAll();
	}

	public List<roles> getRolesById(String UserId) {
		// TODO Auto-generated method stub
		return rolesmapper.getRolesById(UserId);
	}

	public int addRoles(String Id, String UserId, String RoleId) {
		// TODO Auto-generated method stub
		return rolesmapper.addRoles(Id, UserId, RoleId);
	}

	public int delRoles(String UserId, String RoleId) {
		// TODO Auto-generated method stub
		return rolesmapper.delRoles(UserId, RoleId);
	}
		//					´©Ëó¿ò
	public List<modules> getModulesById(String RoleId) {
		// TODO Auto-generated method stub
		return rolesmapper.getModulesById(RoleId);
	}

	public int addModules(Integer Id, int ModuleId, String RoleId) {
		// TODO Auto-generated method stub
		return rolesmapper.addModules(Id, ModuleId, RoleId);
	}

	public int delModules(int ModuleId, String RoleId) {
		// TODO Auto-generated method stub
		return rolesmapper.delModules(ModuleId, RoleId);
	}

	public List<modules> getModulesAll() {
		// TODO Auto-generated method stub
		return rolesmapper.getModulesAll();
	}

	public List<modules> GetSysRightsJsonLayUI(String token) {
		// TODO Auto-generated method stub
		return rolesmapper.GetSysRightsJsonLayUI(token);
	}

	public roles getRoleIdByUserID(String UserId) {
		// TODO Auto-generated method stub
		return rolesmapper.getRoleIdByUserID(UserId);
	}

}
