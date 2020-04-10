package com.ysd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.entity.modules;
import com.ysd.serviceImpl.modulesServiceImpl;

import util.Manager;

@RestController
public class modulesController {
	 @Resource(name="modulesServiceImpl")
	private modulesServiceImpl modulesServiceImpl;
	
		//�ж��ӽڵ� �Ӹ��ڵ����Ϣ������֤
	   public List<Object> modChild(int Id,List<modules> list){
		   List<Object> m = new ArrayList<Object>();
		   for (modules mod: list) {
			if(mod.getParentId()==Id) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", mod.getId());
				map.put("title", mod.getName());
				m.add(map);
			}
		}
		   return m;	   
	   }
	   //��ȾTree����
	   @RequestMapping("/getAllModules")
	   public List<Object> getAllModules(){
		List<Object> list = new ArrayList<Object>();
		List<modules> mo = modulesServiceImpl.getAllModules();
		for (modules m : mo) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(m.getParentId()==0) {
				map.put("id", m.getId());
				map.put("title", m.getName());
				map.put("children", modChild(m.getId(), mo));
				list.add(map);
			}
		}
		   return list;   
	   }
	 @PostMapping(value = "/getModulesById")
	public Map<String, Object> getModulesById(int Id){
		Map<String, Object> ss= Manager.getResultMap();
		modules  mo= modulesServiceImpl.getModulesById(Id);
		if (mo !=null) {
			ss.put("message", mo);
			ss.put("success", true);
		}
		return ss;
	}
	 
	 //����id�޸�
	   @PostMapping("/udModulesById")
	   public   Map<String, Object> udModulesById(int Id, String Name) {
		   
		   int  a = modulesServiceImpl.udModulesById(Id,Name);
		   	System.out.println(a);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {
			   map.put("success",true);
			   map.put("message", "�޸ĳɹ�");
			   }else { 
				   map.put("success",false);
				   map.put("message", "�޸�ʧ��");
			   }
			   return map; 
	   }
	   //����idɾ��
	   @PostMapping("/deleteModulesById")
	   public  Map<String, Object> deleteModulesById(int Id) {
		   int  a = modulesServiceImpl.deleteModulesById(Id);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {	 
			   map.put("success",true);
			   map.put("message", "�h���ɹ�");
		   }else { 
			   map.put("success",false);
			   map.put("message", "�h��ʧ��");
		   }
		   return map;   
	   }
	   //���
	   @GetMapping("/addModulesById")
	   public Map<String, Object> addModulesById(String Name, int ParentId, String Path, int Weight) {
		   int  a = modulesServiceImpl.addModulesById(Name, ParentId, Path, Weight);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {
			   map.put("success",true);
		   map.put("message", "��ӳɹ�");
		   }else { 
			   map.put("message", "���ʧ��");
		   }
		   return map;    
	   }
}
