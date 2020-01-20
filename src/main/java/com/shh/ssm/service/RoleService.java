package com.shh.ssm.service;

import com.shh.ssm.pojo.Role;

import java.util.List;

public interface RoleService {
	
	public Role getRole(Long id);

	public List<Role> getAllRole();
}
