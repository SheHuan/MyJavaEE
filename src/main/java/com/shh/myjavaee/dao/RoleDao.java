package com.shh.myjavaee.dao;

import com.shh.myjavaee.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    public int insertRole(Role role);

    public Role getRole(Long id);

    public List<Role> getAllRole();

    public  int deleteRole(Long id);

    public  int updateRole(Role role);
}
