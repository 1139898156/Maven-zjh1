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
	
		//判断子节点 从父节点的信息进行验证
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
	   //渲染Tree数据
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
	 
	 //根据id修改
	   @PostMapping("/udModulesById")
	   public   Map<String, Object> udModulesById(int Id, String Name) {
		   
		   int  a = modulesServiceImpl.udModulesById(Id,Name);
		   	System.out.println(a);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {
			   map.put("success",true);
			   map.put("message", "修改成功");
			   }else { 
				   map.put("success",false);
				   map.put("message", "修改失败");
			   }
			   return map; 
	   }
	   //根据id删除
	   @PostMapping("/deleteModulesById")
	   public  Map<String, Object> deleteModulesById(int Id) {
		   int  a = modulesServiceImpl.deleteModulesById(Id);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {	 
			   map.put("success",true);
			   map.put("message", "刪除成功");
		   }else { 
			   map.put("success",false);
			   map.put("message", "刪除失败");
		   }
		   return map;   
	   }
	   //添加
	   @GetMapping("/addModulesById")
	   public Map<String, Object> addModulesById(String Name, int ParentId, String Path, int Weight) {
		   int  a = modulesServiceImpl.addModulesById(Name, ParentId, Path, Weight);
		   Map<String, Object> map = new HashMap<String, Object>();
		   if(a>0) {
			   map.put("success",true);
		   map.put("message", "添加成功");
		   }else { 
			   map.put("message", "添加失败");
		   }
		   return map;    
	   }
}
