package com.example.stringCalcuator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorServiceTest {

    StringCalculatorService calculator;

    @Test
    public void handlingEmptyString() {
        calculator = new StringCalculatorService();
        assertEquals(0, calculator.add(""));
    }
}
