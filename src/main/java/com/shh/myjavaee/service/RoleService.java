package com.shh.myjavaee.service;

import com.shh.myjavaee.pojo.Role;

import java.util.List;

public interface RoleService {
	
	public Role getRole(Long id);

	public List<Role> getAllRole();
}
