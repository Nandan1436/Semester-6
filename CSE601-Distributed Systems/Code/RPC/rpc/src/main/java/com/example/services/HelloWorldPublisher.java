package com.example.services;

import jakarta.xml.ws.Endpoint;
import com.example.services.HelloWorldImpl;


public class HelloWorldPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/rpc/helloWorld", new HelloWorldImpl());
        System.out.println("Web Service is published at http://localhost:8888/rpc/helloWorld?wsdl");

    }
}