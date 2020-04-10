package com.ysd.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.roles;
import com.ysd.entity.user;
import com.ysd.mapper.userMapper;
import com.ysd.service.userService;

@Service
@Transactional
public class userServiceImpl implements userService {
	@Autowired
	private userMapper usermapper;

	/*
	 * 查询所有信息
	 */
	public List<user> getallusers(Integer page, Integer limit, String LoginName, String beginDate, String endDate,
			String IsLockout) {
		// TODO Auto-generated method stub
		return usermapper.getAllusers(page, limit, LoginName, beginDate, endDate, IsLockout);
	}

	/*
	 * 查询所有信息条数
	 */

	public int getcount(String LoginName, String beginDate, String endDate, String IsLockout) {
		// TODO Auto-generated method stub
		return usermapper.getCount(LoginName, beginDate, endDate, IsLockout);
	}

	/*
	 * 添加信息
	 */
	public int addUser(String Id, String LoginName, String Password, String IsLockout) {
		// TODO Auto-generated method stub
		return usermapper.addUser(Id, LoginName, Password, IsLockout);
	}

	/*
	 * 删除信息
	 */
	public int deleteUser(String Id) {
		// TODO Auto-generated method stub
		return usermapper.deleteUser(Id);
	}

	/*
	 * 重置密码
	 */
	public int newPass(String Id) {
		// TODO Auto-generated method stub
		return usermapper.newPass(Id);
	}

	public int udUser(String Id, String LoginName, String Password, String IsLockout) {
		// TODO Auto-generated method stub
		return usermapper.udUser(Id, LoginName, Password, IsLockout);
	}

	public int block(String Id, String IsLockout) {
		// TODO Auto-generated method stub
		return usermapper.block(Id, IsLockout);
	}

	public int unblock(String Id, String IsLockout) {
		// TODO Auto-generated method stub
		return usermapper.unblock(Id, IsLockout);
	}

	public roles delUserByRol(String Id) {
		// TODO Auto-generated method stub
		return usermapper.delUserByRol(Id);
	}

	public user loginUser(String LoginName, String Password) {
		// TODO Auto-generated method stub
		return usermapper.loginUser(LoginName, Password);
	}

	public int newLoginTime(String Id,Date LastLoginTime) {
		// TODO Auto-generated method stub
		return usermapper.newLoginTime(Id,LastLoginTime);
	}

	
}
