package com.ysd.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.roles;
import com.ysd.entity.user;

public interface userMapper {
	/*
	 * ��¼
	 */
	public user loginUser(@Param("LoginName")String LoginName,@Param("Password")String Password);
	/*
	 * ��¼����ʱ��
	 */
	public int newLoginTime(@Param("Id") String Id,@Param("LastLoginTime")Date LastLoginTime);
	
	/*
	 * ��ѯ������Ϣ
	 */
	List<user> getAllusers(@Param("page") Integer page, @Param("limit") Integer limit,
			@Param("LoginName") String LoginName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("IsLockout") String IsLockout);
	
	/*
	 * ��ѯ������Ϣ����
	 */

	public int getCount(@Param("LoginName") String LoginName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("IsLockout") String IsLockout);

	/*
	 * �����Ϣ
	 */
	public int addUser(@Param("Id") String Id, @Param("LoginName") String LoginName, @Param("Password") String Password,
			@Param("IsLockout") String IsLockout);

	/*
	 * �޸���Ϣ
	 */
	public int udUser(@Param("Id") String Id, @Param("LoginName") String LoginName, @Param("Password") String Password,
			@Param("IsLockout") String IsLockout);

	/*
	 * ɾ����Ϣ
	 */
	public int deleteUser(@Param("Id") String Id);
	
	/*
	 * ɾ����Ϣ�ж�
	 */
	public roles delUserByRol(@Param("Id") String Id);
	/*
	 * ��������
	 */
	public int newPass(@Param("Id") String Id);

	/*
	 * �����û�
	 */
	public int block(@Param("Id") String Id,@Param("IsLockout") String IsLockout);

	/*
	 * �����û�
	 */
	public int unblock(@Param("Id") String Id,@Param("IsLockout") String IsLockout);
	
}
