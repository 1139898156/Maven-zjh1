package com.ysd.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.roles;

public interface rolesMapperB {
	/*
	 * ��ѯ������Ϣ
	 */
List<roles> getAllroles(@Param("page")Integer page,@Param("limit")Integer limit,@Param("Name")String Name);

/*
 * ��ѯ������Ϣ����
 */

public int getCount();

/*
 * �����Ϣ
 */
public int addRoles(@Param("Id")String Id,@Param("Name")String Name);
/*
 * �޸���Ϣ
 */
public int udRoles(@Param("Id")String Id,@Param("Name")String Name);
/*
 * ɾ����Ϣ
 */
public int deleteRoles(@Param("Id")String Id);

}
