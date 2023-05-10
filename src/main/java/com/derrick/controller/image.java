package com.derrick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class image {

    @RequestMapping("/index")
    public String index(){return "index";
    }
}
