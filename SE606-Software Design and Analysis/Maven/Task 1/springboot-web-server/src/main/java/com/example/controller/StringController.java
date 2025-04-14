package com.example.controller;

import com.example.MyStringLib;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class StringController {
    @PostMapping("/format")
    public void formatString(@RequestParam("inputString") String input){
        System.out.println(MyStringLib.formatString(input));
    }
}
