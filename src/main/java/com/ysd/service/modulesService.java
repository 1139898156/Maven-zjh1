package com.ysd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.modules;

public interface modulesService {
	/*
	 * 查询所有信息
	 */
	public List<modules> getAllModules();
	
	/*
	 * 根据ID查询信息
	 */
	public modules getModulesById(@Param("Id")int Id);


	/*
	 * 添加信息
	 */
	public int addModulesById(@Param("Name") String Name, @Param("ParentId")int ParentId,
			@Param("Path") String Path, @Param("Weight") int Weight);

	/*
	 * 修改信息
	 */
	public int udModulesById(@Param("Id") int Id,@Param("Name")String Name);

	/*
	 * 删除信息
	 */
	public int deleteModulesById(@Param("Id") int Id);

}
