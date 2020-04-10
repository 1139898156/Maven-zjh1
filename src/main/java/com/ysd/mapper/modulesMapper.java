package com.ysd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.modules;
import com.ysd.entity.roles;

public interface modulesMapper {
	/*
	 * ��ѯ������Ϣ
	 */
	public List<modules> getAllModules();
	
	/*
	 * ����ID��ѯ��Ϣ
	 */
	public modules getModulesById(@Param("Id")int Id);


	/*
	 * �����Ϣ
	 */
	public int addModulesById(@Param("Name") String Name, @Param("ParentId")int ParentId,
			@Param("Path") String Path, @Param("Weight") int Weight);

	/*
	 * �޸���Ϣ
	 */
	public int udModulesById(@Param("Id") int Id,@Param("Name")String Name);

	/*
	 * ɾ����Ϣ
	 */
	public int deleteModulesById(@Param("Id") int Id);

}
