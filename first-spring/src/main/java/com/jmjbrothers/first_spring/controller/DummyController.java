package com.jmjbrothers.first_spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class DummyController {


    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/bye")
    public String bye(){
        return "Bye Bye";
    }

    @DeleteMapping("/bye")
    public String delete(){
        return "Delete";
    }

    @GetMapping("/math")
    public int square(@RequestParam int number){
        return number*number;
    }
    @GetMapping("/name")
    public String name(@RequestParam String name1, String name2){
        return "My name is "+name1+". I am the son of "+name2;
    }

    @GetMapping("/done")
    public String returnSomething(){
        return "Ki Obostha Batija, Kaje Monojog Daw.";
    }
}
