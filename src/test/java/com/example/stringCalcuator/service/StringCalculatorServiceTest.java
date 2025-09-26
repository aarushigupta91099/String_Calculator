package com.example.stringCalcuator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorServiceTest {

    StringCalculatorService calculator;

    @Test
    public void handlingEmptyString() {
        calculator = new StringCalculatorService();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void handlingSingleInputString(){
        calculator = new StringCalculatorService();
        assertEquals(1,calculator.add("1"));
    }

    @Test
    public void handlingDoubleInputString(){
        calculator = new StringCalculatorService();
        assertEquals(3,calculator.add("1,2"));
    }

    @Test
    public void handlingMultipleInputString(){
        calculator = new StringCalculatorService();
        assertEquals(7,calculator.add("1,2,4"));
    }

    @Test
    public void handlingNewLineInputString(){
        calculator = new StringCalculatorService();
        assertEquals(6,calculator.add("1,2\n3"));
    }

    @Test
    public void handlingDelimeterInInputString(){
        calculator = new StringCalculatorService();
        assertEquals(6,calculator.add("//;\n1;2;3"));
    }

    @Test
    public void handlingNegativeNumberInputString(){
        calculator = new StringCalculatorService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2"));
        assertEquals("negative numbers not allowed -1",exception.getMessage());
    }
}
