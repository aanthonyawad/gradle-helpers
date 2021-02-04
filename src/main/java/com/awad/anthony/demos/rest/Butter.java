package com.awad.anthony.demos.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Butter {

    @GetMapping(value = "/butter")
    public ModelAndView getTestData() {
        ModelAndView mv = new ModelAndView("butter");
        return mv;
    }
}
