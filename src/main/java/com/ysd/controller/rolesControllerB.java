package com.ysd.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ysd.entity.roles;
import com.ysd.serviceImpl.rolesServiceImplB;

import util.Manager;
import util.Result;

@Controller
public class rolesControllerB {
	@Resource(name = "rolesServiceImplB")
	private rolesServiceImplB rolesserviceImplB;

	/*
	 * 查询所有信息
	 */
	// @ResponseBody Json格式转换 从服务器传数据到浏览器上时转换成JSOn格式
	@RequestMapping("/getAllroles")
	@ResponseBody
	public String getAllroles(Integer page, Integer limit, String Name) {
		int page1 = (page - 1) * limit;
		List<roles> users = rolesserviceImplB.getAllroles(page1, limit, Name);
		
		int count = rolesserviceImplB.getCount();
		String user = Result.toClient("0", "", count, users);
		return user;
	}

	/*
	 * 添加信息
	 */
	@RequestMapping("/addRoles")
	@ResponseBody
	public Map<String, Object> addRoles(String Id, String Name) {
		Map<String, Object> rus = Manager.getResultMap();
		int  a =  rolesserviceImplB.addRoles( Id, Name);
		if (a !=0) {
			rus.put("success", true);
		}
		return rus;
	}

	/*
	 * 删除信息
	 */
	@RequestMapping("/deleteRoles")
	@ResponseBody
	public Map<String, Object> deleteRoles(String Id) {
		Map<String, Object> rus = Manager.getResultMap();
		int a =  rolesserviceImplB.deleteRoles(Id);
		if (a !=0) {
			rus.put("success", true);
		}
		return rus;
	}
	
	
	/*
	 * 修改信息
	 */
	@RequestMapping("/udRoles")
	@ResponseBody
	public Map<String, Object> udRoles(String Id, String Name) {
		Map<String, Object> rus = Manager.getResultMap();
		int a =rolesserviceImplB.udRoles(Id,Name);
		if (a !=0) {
			rus.put("success", true);
		}
		return rus;
	}
	
	
}
