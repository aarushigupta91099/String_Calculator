package com.example.stringCalcuator.service;

import org.springframework.stereotype.Service;

@Service
public class StringCalculatorService {

    public int add(String numbers) {
        return numbers.isEmpty() ? 0 : Integer.parseInt(numbers);
    }
}