package com.ysd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.INEG;
import com.ysd.entity.roles;
import com.ysd.entity.user;
import com.ysd.redis.RedisTrans;
import com.ysd.service.userService;
import com.ysd.serviceImpl.userServiceImpl;

import util.Manager;
import util.Result;

@Controller
public class userController {
	@Resource(name = "userServiceImpl")
	private userServiceImpl userserviceImpl;

	/*
	 * ��ѯ������Ϣ
	 */
	// @ResponseBody Json��ʽת�� �ӷ����������ݵ��������ʱת����JSOn��ʽ
	@RequestMapping("/getUsers")
	@ResponseBody
	public String getUsers(Integer page, Integer limit, String LoginName, String beginDate, String endDate,
			String IsLockout) {
		int page1 = (page - 1) * limit;
		List<user> users = userserviceImpl.getallusers(page1, limit, LoginName, beginDate, endDate, IsLockout);
		/* System.out.println(IsLockout); */
		int count = userserviceImpl.getcount(LoginName, beginDate, endDate, IsLockout);
		String user = Result.toClient("0", "", count, users);
		return user;
	}

	/*
	 * �����Ϣ
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public int addUser(String Id, String LoginName, String Password, String IsLockout) {
		int a = 0;
		a = userserviceImpl.addUser(Id, LoginName, Password, IsLockout);
		if (a > 0) {
			System.out.println("��ӳɹ�");
		}
		return a;
	}

	/*
	 * ɾ����Ϣ
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public int deleteUser(String Id) {
		int a = 0;
		a = userserviceImpl.deleteUser(Id);
		if (a > 0) {
			System.out.println("ɾ���ɹ�");
		}
		return a;
	}
	
	/*
	 * ɾ����Ϣ�ж�
	 */
	@RequestMapping("/delUserByRol")
	@ResponseBody
	public Map<String,Object> delUserByRol(String Id) {
		roles r = userserviceImpl.delUserByRol(Id);
		  Map<String, Object> resultMap= Manager.getResultMap();
		  
		if (r!=null) {
			resultMap.put("success", true);
		}
		return resultMap;
	}

	/*
	 * ��������
	 */
	@RequestMapping("/newPass")
	@ResponseBody
	public int newPass(String Id) {
		int a = 0;
		a = userserviceImpl.newPass(Id);
		if (a > 0) {
			System.out.println("���óɹ�");
		}
		return a;
	}

	/*
	 * �޸���Ϣ
	 */
	@RequestMapping("/udUser")
	@ResponseBody
	public int udUser(String Id, String LoginName, String Password, String IsLockout) {
		int a = 0;
		a = userserviceImpl.udUser(Id, LoginName, Password, IsLockout);
		if (a > 0) {
			System.out.println("�޸ĳɹ�");
		}
		return a;
	}
	
	/*
	 * �����û�
	 */
	@RequestMapping("/block")
	@ResponseBody
	public int block(String Id, String IsLockout) {
		int a = 0;
		a = userserviceImpl.block(Id, IsLockout);
		if (a > 0) {
			System.out.println("�����ɹ�");
		}
		return a;
	}
	/*
	 * �����û�
	 */
	@RequestMapping("/unblock")
	@ResponseBody
	public int unblock(String Id,String IsLockout) {
		int a = 0;
		a = userserviceImpl.unblock(Id, IsLockout);
		if (a > 0) {
			System.out.println("�����ɹ�");
		}
		return a;
	}
	/*
	 * �û���¼
	 */
	@Resource(name="redisTrans")
	 private RedisTrans redisTrans;
	@RequestMapping("/loginUser")
	@ResponseBody
	public Map<String, Object> loginUser(String LoginName, String Password) {
		user a = userserviceImpl.loginUser(LoginName, Password);
		  Map<String, Object> resultMap= Manager.getResultMap();
		 String roleId=a.getId();
		 redisTrans.setString("uid",roleId);
		  System.out.println(redisTrans.getString("uid"));
		if (a!=null) {
			resultMap.put("success", true);
			resultMap.put("message", a);
			resultMap.put("uid", roleId);
		}
		return resultMap;
	}
	

	/*
	 * �����û���½ʱ��
	 */
	@RequestMapping("/newLoginTime")
	@ResponseBody
	public Map<String, Object> newLoginTime(String Id,Date LastLoginTime) {
		Date newDate= new Date();
		LastLoginTime =newDate;
		int a =  userserviceImpl.newLoginTime(Id,LastLoginTime);
		 Map<String, Object> resultMap= Manager.getResultMap();
		if (a > 0) {
			resultMap.put("success", true);
			
		}
		return resultMap;
	}
	
}
