package com.shh.myjavaee.controller;

import com.shh.myjavaee.pojo.Role;
import com.shh.myjavaee.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/getRoles")
    public ModelAndView getRoles(ModelAndView mv) {
        List<Role> roles = roleService.getAllRole();
        mv.setViewName("role");
        mv.addObject("roles", roles);
        return mv;
    }

    @RequestMapping("/getRoles2")
    public String getRoles2(Model model) {
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("roles", roles);
        return "role";
    }

    @RequestMapping("/getRoles3")
    public ModelAndView getRoles3() {
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.getAllRole();
        mv.addObject("roles", roles);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/getRoles4")
    @ResponseBody
    public List<Role> getRoles4() {
        List<Role> roles = roleService.getAllRole();
        return roles;
    }

    @RequestMapping("/getRole/{id}")
    @ResponseBody
    public Role getRole(@PathVariable("id") long id) {
        Role role = roleService.getRole(id);
        return role;
    }

    @RequestMapping("/roleForm")
    public String roleForm() {
        return "roleForm";
    }

    @RequestMapping("/roleForm2")
    public String roleForm2() {
        return "roleForm2";
    }

    @RequestMapping("/commonParams")
    public ModelAndView commonParams(String roleName, String note) {
        ModelAndView mv = new ModelAndView();
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        mv.addObject("role", role);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/commonParams2")
    public ModelAndView commonParams2(@RequestParam(value = "role_name", required = false) String roleName, String note) {
        return commonParams(roleName, note);
    }

    @RequestMapping("/commonParams3")
    public ModelAndView commonParams3(Role role) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/pathParams/{id}")
    public ModelAndView pathParams(@PathVariable("id") long id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/jsonParams")
    @ResponseBody
    public Role jsonParams(@RequestBody Role role) {
        return role;
    }

    @RequestMapping("/jsonParams2")
    @ResponseBody
    public Role jsonParams2(@RequestBody List<Role> roles) {
        return roles.get(0);
    }

    @RequestMapping("/serializeParams")
    @ResponseBody
    public Role serializeParams(Role role) {
        return role;
    }
}
