package com.example.paymentservice_experiment1.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/{id}")
    public String getHello(@PathVariable("id") Long id){
        return "Hello world "+id ;
    }
}
