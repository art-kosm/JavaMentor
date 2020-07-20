package com.company;

public class Calculator {
    public String performOperation(String [] operands, char operation) {
        int resultValue = 0;
        int first = 0;
        int second = 0;
        boolean isRoman = false;

        // определяем числа (будь они римские или арабские)
        Converter converter = new Converter();
        if (operands[0].contains("I") || operands[0].contains("V") || operands[0].contains("X")) {
            first = converter.toArabic(operands[0]);
            second = converter.toArabic(operands[1]);
            isRoman = true;
        } else {
            first = Integer.parseInt(operands[0]);
            second = Integer.parseInt(operands[1]);
        }

        if (first < 1 || first > 10 || second < 1 || second > 10)
            throw new ArithmeticException();

        // считаем
        switch (operation) {
            case '+':
                resultValue = first + second;
                break;
            case '-':
                resultValue = first - second;
                break;
            case '*':
                resultValue = first * second;
                break;
            case '/':
                resultValue = first / second;
                break;
        }

        // формируем ответ (римское или арабское число)
        String resultString = "";
        if (isRoman)
            resultString = converter.toRoman(resultValue);
        else
            resultString = Integer.toString(resultValue);

        return resultString;
    }
}
