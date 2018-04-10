package com.udea.release1.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController 
{
		
    @RequestMapping("/saludo")
    String hellow() 
    {
        return "Hello World!";
    }
}