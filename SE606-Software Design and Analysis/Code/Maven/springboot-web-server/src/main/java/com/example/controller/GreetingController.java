package com.example.controller;

import com.example.MyCustomLib;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class GreetingController {
    @PostMapping("/greet")
    public String greet(@RequestParam("name") String input){
        String formattedStr=MyCustomLib.greet(input);
        System.out.println(formattedStr);
        return "<p>" + formattedStr + "<p>";
    }
}
