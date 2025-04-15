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
    public String formatString(@RequestParam("inputString") String input){
        String formattedStr=MyStringLib.formatString(input);
        System.out.println(formattedStr);
        return "<p>" + formattedStr + "<p>";
    }
}
