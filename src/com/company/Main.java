package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // читаем строку
        System.out.print("Введите выражение: ");
        String input = in.nextLine().replaceAll("\\s", ""); // считываем строку, игнорируя пробелы
        in.close();

        // определяем операцию в строке (ровно одна)
        char operation = ' ';
        if (input.contains("+"))
            operation = '+';
        else if (input.contains("-"))
            operation = '-';
        else if (input.contains("*"))
            operation = '*';
        else if (input.contains("/"))
            operation = '/';

        // определяем операнды в строке
        String regex = "\\" + Character.toString(operation);
        String [] splitted = input.split(regex);

        Calculator calculator = new Calculator();

        //считаем
        String result = calculator.performOperation(splitted, operation);
        System.out.println(result);
    }
}
