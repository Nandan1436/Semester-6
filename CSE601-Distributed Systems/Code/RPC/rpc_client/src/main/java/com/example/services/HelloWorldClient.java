package com.example.services;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class HelloWorldClient {
    public static void main(String[] args) throws Exception {

        URL serviceUrl = new URL("http://192.168.68.106:8888/rpc/helloWorld?wsdl");
        QName serviceQName = new QName("http://services.example.com/", "HelloWorldImplService");
        Service service = Service.create(serviceUrl, serviceQName);
        QName portQName = new QName("http://services.example.com/", "HelloWorldImplPort");

        HelloWorld hello = service.getPort(portQName, HelloWorld.class);
        String response = hello.getHelloWorldAsString("Nandan");

        System.out.println("Response from server: " + response);
    }
}
