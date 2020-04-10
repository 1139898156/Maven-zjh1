package com.ysd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.modules;
import com.ysd.entity.roles;

public interface rolesMapper {
	 	 

	/*
	 * ��ȡ���н�ɫ
	 * */
	public List<roles> getRolesAll(); 
	
	/*
	 * ����ID��ȡ��ɫ
	 * */
	public List<roles> getRolesById(@Param("UserId")String UserId); 
	/*
	 * ����ID�޸Ľ�ɫ
	 * */
	public int addRoles(@Param("Id")String Id,@Param("UserId")String UserId,@Param("RoleId")String RoleId); 
	/*
	 * ����IDɾ����ɫ
	 * */
	public int delRoles(@Param("UserId")String UserId,@Param("RoleId")String RoleId); 
	

	
	/*
	 * 	�����
	 * ����rolesID��ȡģ��
	 * */
	
	public List<modules> getModulesAll();
	public List<modules> getModulesById(@Param("RoleId")String RoleId); 
	/*
	 * ����ID�޸Ľ�ɫ
	 * */
	public int addModules(@Param("Id")Integer Id,@Param("ModuleId")int ModuleId,@Param("RoleId")String RoleId); 
	/*
	 * ����IDɾ����ɫ
	 * */
	public int delModules(@Param("ModuleId")int ModuleId,@Param("RoleId")String RoleId); 
	public roles getRoleIdByUserID(@Param("UserId")String UserId); 
	
	public List<modules> GetSysRightsJsonLayUI(@Param("token")String token);
}
