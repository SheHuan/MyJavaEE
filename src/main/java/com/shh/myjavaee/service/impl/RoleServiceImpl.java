package com.shh.myjavaee.service.impl;

import com.shh.myjavaee.dao.RoleDao;
import com.shh.myjavaee.pojo.Role;
import com.shh.myjavaee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao = null;
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Role getRole(Long id) {
		return roleDao.getRole(id);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Role> getAllRole() {
		return roleDao.getAllRole();
	}

}
