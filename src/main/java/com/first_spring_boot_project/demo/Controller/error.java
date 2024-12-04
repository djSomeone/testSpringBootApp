package com.first_spring_boot_project.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class error {
    @GetMapping("/error")
    
    public String onError(){
        return "there is some thing went wroong";
    }
}
