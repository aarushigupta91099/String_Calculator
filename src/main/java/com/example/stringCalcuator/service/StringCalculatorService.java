package com.example.stringCalcuator.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class StringCalculatorService {

    public int add(String numbers) {
        if(numbers.isEmpty()){
            return 0;
        }
        //delimeter
        String delimeters = ",|\n";
        String numberPart = numbers;
        if(numbers.startsWith("//")){
            int delimeterEndIndex = numbers.indexOf("\n");
            String delimiterDeclaration = numbers.substring(2, delimeterEndIndex);

            if (delimiterDeclaration.startsWith("[")) {
                delimeters = extractMultiCharacterDelimiter(delimiterDeclaration);
            } else {
                delimeters = Pattern.quote(delimiterDeclaration);
            }
            numberPart = numbers.substring(delimeterEndIndex + 1);
        }

        String[] num = numberPart.split(delimeters);
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

    private String extractMultiCharacterDelimiter(String delimiterDeclaration) {
        return Arrays.stream(delimiterDeclaration.split("\\[|\\]"))
                .filter(part -> !part.isEmpty())
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}