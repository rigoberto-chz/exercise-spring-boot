package com.example.h2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	@RequestMapping("/")
    public String home(){
        return "Hello Welcome!";
    }
	
}
