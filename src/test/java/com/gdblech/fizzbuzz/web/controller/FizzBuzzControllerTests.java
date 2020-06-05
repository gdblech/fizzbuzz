package com.gdblech.fizzbuzz.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest
public class FizzBuzzControllerTests {
    private static final String BASE_URL = "http://localhost:8080/";

    private RestTemplate restTemplate = new RestTemplate();


    @Test
    public void whenNumberIsMultipleOf3OnFizzBuzz_thenFizz(){
        String expected = "Fizz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "9", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsMultipleOf5OnFizzBuzz_thenBuzz(){
        String expected = "Buzz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "25", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsMultipleOf3And5OnFizzBuzz_thenFizzBuzz(){
        String expected = "FizzBuzz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "15", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsNeitherOnFizzBuzz_thenNumber(){
        String expected = "14";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "14", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

}
