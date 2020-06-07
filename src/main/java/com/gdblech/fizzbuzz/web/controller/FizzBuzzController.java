package com.gdblech.fizzbuzz.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FizzBuzzController {

    private final String FIRSTRETURN = "Fizz";
    private final String SECONDRETURN = "Buzz";

    //Takes any positive number as the request body and returns its fizz status
    @GetMapping(value = "/fizz/{number}")
    public String fizzEval(@PathVariable Long number) {
        inputValidation(number);
        if (fizzDecider(number)) {
            return FIRSTRETURN;
        }
        return number.toString();
    }

    //Takes any positive number as the request body and returns its buzz status
    @GetMapping(value = "/buzz/{number}")
    public String buzzEval(@PathVariable Long number) {
        inputValidation(number);

        if (buzzDecider(number)) {
            return SECONDRETURN;
        }
        return number.toString();
    }

    //Takes any positive number as a path variable and returns its fizzBuzz status.
    @GetMapping(value = "/{number}")
    public String fizzBuzzEval(@PathVariable Long number) {
        inputValidation(number);

        StringBuffer response = new StringBuffer();
        boolean flipBit = false;


        if (fizzDecider(number)) {
            response.append(FIRSTRETURN);
            flipBit = true;
        }
        if (buzzDecider(number)) {
            response.append(SECONDRETURN);
            flipBit = true;
        }

        if (flipBit) {
            return response.toString();
        } else {
            return number.toString();
        }
    }

    //get the full fizzbuzz chain.
    @GetMapping(value = "/fizzbuzz/{number}")
    public String fullFizzBuzz(@PathVariable Long number) {
        StringBuffer response = new StringBuffer();
        for (long i = 1; i <= number; i++) {
            boolean flipBit = false;
            if (fizzDecider(i)) {
                response.append(FIRSTRETURN);
                flipBit = true;
            }
            if (buzzDecider(i)) {
                response.append(SECONDRETURN);
                flipBit = true;
            }

            if (!flipBit) {
                response.append(i);
            }
            if (i != number) {
                response.append(",");
            }
        }

        return response.toString();
    }


    //Multiple of 3, true
    private boolean fizzDecider(long number) {
        return number % 3 == 0;
    }

    //Multiple of 5, true
    private boolean buzzDecider(long number) {
        return number % 5 == 0;
    }

    private void inputValidation(Long number) {
        if (number == null || number < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Value");
        }
    }

}
