package com.ysd.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.roles;
import com.ysd.entity.user;

public interface userService {
	
	/*
	 * 查询所有信息
	 */

	List<user> getallusers(@Param("page") Integer page, @Param("limit") Integer limit,
			@Param("LoginName") String LoginName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("IsLockout") String IsLockout);

	/*
	 * 查询所有信息条数
	 */

	public int getcount(@Param("LoginName") String LoginName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("IsLockout") String IsLockout);

	/*
	 * 添加信息
	 */
	public int addUser(@Param("Id") String Id, @Param("LoginName") String LoginName, @Param("Password") String Password,
			@Param("IsLockout") String IsLockout);

	/*
	 * 修改信息
	 */
	public int udUser(@Param("Id") String Id, @Param("LoginName") String LoginName, @Param("Password") String Password,
			@Param("IsLockout") String IsLockout);

	/*
	 * 删除信息
	 */
	public int deleteUser(@Param("Id") String Id);
	
	/*
	 * 删除信息判断
	 */
	public roles delUserByRol(@Param("Id") String Id);
	
	/*
	 * 重置密码
	 */
	public int newPass(@Param("Id") String Id);

	/*
	 * 锁定用户
	 */
	public int block(@Param("Id") String Id,@Param("IsLockout") String IsLockout);

	/*
	 * 解锁用户
	 */
	public int unblock(@Param("Id") String Id,@Param("IsLockout") String IsLockout);
	
	/*
	 * 登录
	 */
	public user loginUser(@Param("LoginName")String LoginName,@Param("Password")String Password);
	/*
	 * 登录更新时间
	 */
	public int newLoginTime(@Param("Id") String Id,@Param("LastLoginTime")Date LastLoginTime);
}
