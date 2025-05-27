package com.example.services;

import jakarta.xml.ws.Endpoint;
import com.example.services.HelloWorldImpl;


public class HelloWorldPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://192.168.68.106:8888/rpc/helloWorld", new HelloWorldImpl());
        System.out.println("Web Service is published at http://192.168.68.106:8888/rpc/helloWorld?wsdl");
    }
}