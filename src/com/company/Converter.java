package com.company;

import java.util.Set;

public class Converter {
    public boolean isCorrectRoman(String num) {
        Set<String> correctRomans = Set.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        return correctRomans.contains(num);
    }

    public int toArabic(String num) {
        if (!isCorrectRoman(num))
            throw new ArithmeticException();

        if (num.equals("X"))
            return 10;
        else if (num.equals("IX"))
            return 9;
        else if (num.startsWith("V"))
            return 4 + num.length(); // = 5 + число единичек в строке
            // например VII это 5 + 2 единички или 4 + 3
        else if (num.equals("IV"))
            return 4;

        return num.length(); // если I, II или III
    }

    public String toRoman(int num) {
        String resultString = "";

        if (num < 0) {
            resultString += "-";
            num = -num; // дальше работаем только с положительными числами
        }

        int tens = 0;
        int ones = num;
        if (num > 10) { // разбиваем число на десятки и единицы, потом сложим из них римское число
            tens = num / 10; // не больше 10 (максимум: 10 * 10 = 100)
            ones = num % 10;
        }

        if (tens == 10)
            resultString += "C";
        else if (tens == 9)
            resultString += "XC";
        else if (tens >= 5) {
            resultString += "L";
            for (int i = tens - 5; i > 0; i--) {
                resultString += "X";
            }
        } else if (tens == 4)
            resultString += "XL";
        else
            for (int i = tens; i > 0; i--) {
                resultString += "X";
            }

        if (ones == 10)
            resultString += "X";
        else if (ones == 9)
            resultString += "IX";
        else if (ones >= 5) {
            resultString += "V";
            for (int i = ones - 5; i > 0; i--) {
                resultString += "I";
            }
        } else if (ones == 4)
            resultString += "IV";
        else
            for (int i = ones; i > 0; i--) {
                resultString += "I";
            }

        return resultString;
    }
}
