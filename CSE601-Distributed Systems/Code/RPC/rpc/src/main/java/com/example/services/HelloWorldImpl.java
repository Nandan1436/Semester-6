package com.example.services;

import jakarta.jws.WebService;
import com.example.services.HelloWorld;

@WebService(endpointInterface = "com.example.services.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello, " + name + "! This is the response from server!";
    }
}