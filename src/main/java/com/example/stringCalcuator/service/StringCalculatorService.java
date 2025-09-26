package com.example.stringCalcuator.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StringCalculatorService {

    public int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        String[] num = numbers.split(",");
        int numSum = 0;
        numSum = Arrays.stream(num).mapToInt(Integer::parseInt).sum();
        return numSum;
    }
}