package com.ysd.entity;

public class rolemodules {
	private String Id;
	private String RoleId;
	private Integer ModuleId;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public Integer getModuleId() {
		return ModuleId;
	}
	public void setModuleId(Integer moduleId) {
		ModuleId = moduleId;
	}
	public rolemodules(String id, String roleId, Integer moduleId) {
		super();
		Id = id;
		RoleId = roleId;
		ModuleId = moduleId;
	}
	public rolemodules() {
		super();
	}
	@Override
	public String toString() {
		return "rolemodules [Id=" + Id + ", RoleId=" + RoleId + ", ModuleId=" + ModuleId + "]";
	}

}
