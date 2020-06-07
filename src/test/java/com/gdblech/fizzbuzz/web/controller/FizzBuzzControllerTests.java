package com.gdblech.fizzbuzz.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;


@SpringBootTest
public class FizzBuzzControllerTests {
    private static final String BASE_URL = "http://localhost:8080/";

    private final RestTemplate restTemplate = new RestTemplate();


    @Test
    public void whenNumberIsMultipleOf3_onNumber_thenFizz() {
        String expected = "Fizz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "9", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsMultipleOf5_onNumber_thenBuzz() {
        String expected = "Buzz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "25", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsMultipleOf3And5_onNumber_thenFizzBuzz() {
        String expected = "FizzBuzz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "15", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsNeither_onNumber_thenNumber() {
        String expected = "7";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "7", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsMultipleOf3_onFizz_thenFizz() {
        String expected = "Fizz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "/fizz/9", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsNot3_onFizz_thenNumber() {
        String expected = "5";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "fizz/5", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsMultipleOf5_onBuzz_thenBuzz() {
        String expected = "Buzz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "buzz/10", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumberIsNot5_onBuzz_thenNumber() {
        String expected = "3";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "buzz/3", String.class);
        assertEquals(expected, responseEntity.getBody());
    }

    @Test
    public void whenNumber_onFizzBuzz_thenCorrect() {
        String expected = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(BASE_URL + "fizzbuzz/15", String.class);
        assertEquals(expected, responseEntity.getBody());
    }
}
