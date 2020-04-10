package com.ysd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.modules;
import com.ysd.entity.roles;

public interface rolesMapper {
	 	 

	/*
	 * 获取所有角色
	 * */
	public List<roles> getRolesAll(); 
	
	/*
	 * 根据ID获取角色
	 * */
	public List<roles> getRolesById(@Param("UserId")String UserId); 
	/*
	 * 根据ID修改角色
	 * */
	public int addRoles(@Param("Id")String Id,@Param("UserId")String UserId,@Param("RoleId")String RoleId); 
	/*
	 * 根据ID删除角色
	 * */
	public int delRoles(@Param("UserId")String UserId,@Param("RoleId")String RoleId); 
	

	
	/*
	 * 	穿梭框
	 * 根据rolesID获取模块
	 * */
	
	public List<modules> getModulesAll();
	public List<modules> getModulesById(@Param("RoleId")String RoleId); 
	/*
	 * 根据ID修改角色
	 * */
	public int addModules(@Param("Id")Integer Id,@Param("ModuleId")int ModuleId,@Param("RoleId")String RoleId); 
	/*
	 * 根据ID删除角色
	 * */
	public int delModules(@Param("ModuleId")int ModuleId,@Param("RoleId")String RoleId); 
	public roles getRoleIdByUserID(@Param("UserId")String UserId); 
	
	public List<modules> GetSysRightsJsonLayUI(@Param("token")String token);
}
