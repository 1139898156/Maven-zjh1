package com.ysd.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.roles;

public interface rolesMapperB {
	/*
	 * 查询所有信息
	 */
List<roles> getAllroles(@Param("page")Integer page,@Param("limit")Integer limit,@Param("Name")String Name);

/*
 * 查询所有信息条数
 */

public int getCount();

/*
 * 添加信息
 */
public int addRoles(@Param("Id")String Id,@Param("Name")String Name);
/*
 * 修改信息
 */
public int udRoles(@Param("Id")String Id,@Param("Name")String Name);
/*
 * 删除信息
 */
public int deleteRoles(@Param("Id")String Id);

}
