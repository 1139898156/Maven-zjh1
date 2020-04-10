package com.ysd.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.roles;
import com.ysd.mapper.rolesMapperB;

@Service
public class rolesServiceImplB implements rolesMapperB{
	@Autowired
	private rolesMapperB rolesmapperB;

	public List<roles> getAllroles(Integer page, Integer limit, String Name) {
		// TODO Auto-generated method stub
		return rolesmapperB.getAllroles(page, limit, Name);
	}

	public int addRoles(String Id, String Name) {
		// TODO Auto-generated method stub
		return rolesmapperB.addRoles(Id, Name);
	}

	public int udRoles(String Id,String Name) {
		// TODO Auto-generated method stub
		return rolesmapperB.udRoles(Id,Name);
	}

	public int deleteRoles(String Id) {
		// TODO Auto-generated method stub
		return rolesmapperB.deleteRoles(Id);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return rolesmapperB.getCount();
	}

}
