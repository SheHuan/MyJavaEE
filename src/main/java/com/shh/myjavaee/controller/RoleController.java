package com.shh.myjavaee.controller;

import com.shh.myjavaee.pojo.Role;
import com.shh.myjavaee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/getRoles")
    public ModelAndView getRoles() {
        List<Role> roles = roleService.getAllRole();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role");
        mv.addObject("roles", roles);
        return mv;
    }

    @RequestMapping("/getRole/{id}")
    @ResponseBody
    public Object getRole(@PathVariable("id") long id) {
        Role role = roleService.getRole(id);
        return role;
    }
}
