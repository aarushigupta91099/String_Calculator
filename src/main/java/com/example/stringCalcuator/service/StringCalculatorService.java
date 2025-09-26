package com.example.stringCalcuator.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StringCalculatorService {

    public int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        //delimeter
        String delimeters = ",|\n";
        if(numbers.startsWith("//")){
            delimeters = numbers.substring(2,3);
            numbers = numbers.substring(4);
        }

        String[] num = numbers.split(delimeters);
        int numSum = 0;
        List<Integer> negativeNumbers = Arrays.stream(num)
                .mapToInt(Integer::parseInt)
                .filter(negNum -> negNum < 0)
                .boxed()
                .toList();
        if(!negativeNumbers.isEmpty()){
            throw new IllegalArgumentException("negative numbers not allowed "+negativeNumbers);
        }
        numSum = Arrays.stream(num).filter(nNum -> !nNum.isEmpty()).mapToInt(Integer::parseInt).filter(nNum -> nNum <= 1000).sum();
        return numSum;
    }
}