package com.HMB.HW14TodoList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControllerThymeleaf {
    @GetMapping("/testth")
    public ModelAndView test() {
        ModelAndView result = new ModelAndView("Test Controller with Thymleaf");
        result.addObject("message", "Hello, Maryna");
        result.setViewName("test");
        return result;
    }
}
