package com.ysd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.protobuf.TextFormat.ParseException;
import com.ysd.entity.modules;
import com.ysd.entity.roles;
import com.ysd.serviceImpl.modulesServiceImpl;
import com.ysd.serviceImpl.rolesServiceImpl;

import util.Manager;

@RestController
@RequestMapping("/api")
public class rolesController {

	@Resource(name = "rolesServiceImpl")
	private rolesServiceImpl rolesserviceImpl;

	// ��ɫ��ȡ
	@PostMapping("/getRolesAll")
	public List<roles> getRolesAll() throws ParseException {
		List<roles> roles = rolesserviceImpl.getRolesAll();
		//System.out.println(roles);
		return roles;
	}

	// ById��ɫ��ȡ
	@PostMapping("/getRolesById")
	public List<roles> getRolesById(String UserId) throws ParseException {
		System.out.println(UserId);
		List<roles> r = rolesserviceImpl.getRolesById(UserId);
		//System.out.println(r);
		return r;
	}
	// ��ɫ�޸�
		@PostMapping("/addRoles")
		public  Map<String, Object> addRoles(String Id,String UserId,String RoleId) throws ParseException {
			Map<String, Object> res = Manager.getResultMap();
			int r = rolesserviceImpl.addRoles(Id, UserId, RoleId);
		if (r>0) {
			res.put("success", true);
		}
			return res;
		}
		// ById��ɫɾ��
		@PostMapping("/delRoles")
		public  Map<String, Object> delRoles(String UserId,String RoleId) throws ParseException {
			Map<String, Object> res = Manager.getResultMap();
			int r = rolesserviceImpl.delRoles(UserId, RoleId);
		if (r>0) {
			res.put("success", true);
		}
			return res;
		}
		/*
		 * �����
		 * **/
		
		 //getAllModules
		   @RequestMapping("/getModulesAll")
		   public List<Object> getModulesAll() throws ParseException{
			   List<Object> list = new ArrayList<Object>();
			List<modules> mo = rolesserviceImpl.getModulesAll();
			for (modules m : mo) {
				Map<String, Object> map = new HashMap<String, Object>();
				if(m.getParentId()==0) {
					map.put("value", m.getId());
					map.put("title", m.getName());
					list.add(map);
				}
			}
			//System.out.println(mo);
			   return list;   
		   }
		// ById��ɫ��ȡ
			@PostMapping("/getModulesById")
			public List<Object> getModulesById(String RoleId) throws ParseException {
				List<Object> list = new ArrayList<Object>();
				//System.out.println(RoleId);
				List<modules> r = rolesserviceImpl.getModulesById(RoleId);
				for (modules m : r) {
					//System.out.println(m);
					Map<String, Object> map = new HashMap<String, Object>();
					if (m.getParentId()==0) {
						map.put("id", m.getId());
						map.put("title", m.getName());
						list.add(map);
					}
						
				}
				//System.out.println(r);
				return list;
			}
			// ��ɫ�޸�
				@PostMapping("/addModules")
				public  Map<String, Object> addModules(Integer Id, int ModuleId, String RoleId) throws ParseException {
					Map<String, Object> res = Manager.getResultMap();
					int r = rolesserviceImpl.addModules(Id, ModuleId, RoleId);
				if (r>0) {
					res.put("success", true);
				}
					return res;
				}
				// ById��ɫɾ��
				@PostMapping("/delModules")		
				public  Map<String, Object> delModules(int ModuleId, String RoleId) throws ParseException {
					Map<String, Object> res = Manager.getResultMap();
					int r = rolesserviceImpl.delModules(ModuleId, RoleId);
				if (r>0) {
					res.put("success", true);
				}
					return res;
				}
				
				// ��̬Ŀ¼   ById��ɫ��ȡ
				@PostMapping("/getRoleIdByUserID")
				public roles getRoleIdByUserID(String UserId) throws ParseException {
					System.out.println(UserId);
					roles r =rolesserviceImpl.getRoleIdByUserID(UserId);
					return r;
				}
				//��̬Ŀ¼   ById��ɫ��ȡ
				
				//�ж��ӽڵ� �Ӹ��ڵ����Ϣ������֤
				   public List<Object> modChild(int Id,List<modules> list){
					   List<Object> m = new ArrayList<Object>();
					   for (modules mod: list) {
						if(mod.getParentId()==Id) {
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("id", mod.getId());
							map.put("href", mod.getPath());
							map.put("title", mod.getName());
							m.add(map);
						}
					}
					   return m;	   
				   }
				   //��ȾTree����
				   @RequestMapping("/GetSysRightsJsonLayUI")
				   public List<Object> GetSysRightsJsonLayUI(String token){
					   System.out.println("tooken"+token);
					List<Object> list = new ArrayList<Object>();
					List<modules> mo = rolesserviceImpl.GetSysRightsJsonLayUI(token);
					for (modules m : mo) {
						Map<String, Object> map = new HashMap<String, Object>();
						if(m.getParentId()==0) {
							map.put("id", m.getId());
							map.put("title", m.getName());
							//map.put("href", m.getPath());
							map.put("children", modChild(m.getId(), mo));
							list.add(map);
						}
					}
					System.out.println(list);
					   return list;   
				   }
}
