package com.shh.ssm.controller;

import com.shh.ssm.pojo.Role;
import com.shh.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @RequestMapping("/addRole")
    public String addRole(Model model, Role role) {
        model.addAttribute("roleName", role.getRoleName());
        model.addAttribute("note", role.getNote());
        return "redirect:./result";
    }

    @RequestMapping("/addRole2")
    public String addRole2(Model model, Role role) {
        model.addAttribute("roleName", role.getRoleName());
        model.addAttribute("note", role.getNote());
        return "redirect:./result2/{roleName}";
    }

    @RequestMapping("/addRole3")
    public String addRole3(RedirectAttributes ra, Role role) {
        ra.addFlashAttribute("role", role);
        return "redirect:./result3";
    }

    @RequestMapping("/addRole4")
    public String addRole4(RedirectAttributes ra, Role role) {
        ra.addFlashAttribute("role", role);
        return "redirect:/result/success";
    }

    @RequestMapping("/addRole5")
    public String addRole5(Model model, Role role) {
        model.addAttribute("roleName", role.getRoleName());
        return "forward:./fail";
    }

    @RequestMapping("/addRole6")
    public ModelAndView addRole6( Role role) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleName", role.getRoleName());
        mv.setViewName("forward:./fail");
        return mv;
    }

    @RequestMapping("/addRole7")
    public ModelAndView addRole7(ModelAndView mv, Role role) {
        mv.addObject("roleName", role.getRoleName());
        mv.setViewName("forward:/result/fail");
        return mv;
    }

    @RequestMapping("/result")
    public String result(Model model, Role role) {
        return "result";
    }

    @RequestMapping("/result2/{roleName}")
    public String result2(Model model, @PathVariable("roleName") String roleName, String note) {
        model.addAttribute("roleName", roleName);
        model.addAttribute("note", note);
        return "result2";
    }

    @RequestMapping("/result3")
    public String result3(Model model) {
        return "result";
    }

    @RequestMapping("/fail")
    public String fail() {
        return "fail";
    }
}
