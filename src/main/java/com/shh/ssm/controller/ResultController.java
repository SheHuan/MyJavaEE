package com.shh.ssm.controller;

import com.shh.ssm.pojo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class ResultController {
    @RequestMapping("/success")
    public String result(Role role) {
        return "result";
    }

    @RequestMapping("/fail")
    public String fail() {
        return "fail";
    }
}
