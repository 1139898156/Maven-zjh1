package com.ysd.entity;

public class userroles {
	private String Id;
	private String UserId;
	private String RoleId;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public userroles(String id, String userId, String roleId) {
		super();
		Id = id;
		UserId = userId;
		RoleId = roleId;
	}
	public userroles() {
		super();
	}
	@Override
	public String toString() {
		return "userroles [Id=" + Id + ", UserId=" + UserId + ", RoleId=" + RoleId + "]";
	}
	
}
