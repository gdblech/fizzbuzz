package com.gdblech.fizzbuzz.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class FizzBuzzController {

    //Takes any positive number as a path variable and returns its fizzbuzz status.
    @GetMapping(value = "/{number")
    public String fizzBuzzEval(@PathVariable Long number){
        return null;
    }

    //Takes any positive number as the request body and returns its fizz status
    @GetMapping(value = "/fizz")
    public String fizzEval(@RequestBody Long number){
        return null;
    }

    //Takes any positive number as the request body and returns its buzz status
    @GetMapping(value = "/buzz")
    public String buzzEval(@RequestBody Long number){
        return null;
    }

    private String checkFizzStatus(Long number){
        return null;
    }

    private String checkBuzzStatus(Long number){
        return null;
    }


}
