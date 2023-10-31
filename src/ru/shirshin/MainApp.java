package ru.shirshin;

import java.util.Scanner;

public class MainApp {

    static Calculator getCalculator(String input) {

        // TODO RomainCalculator

        if (input.matches("^([1-9]|10)(\\s|)[/*+-](\\s|)([1-9]|10)$")) {
            return new ArabianCalculator(input);
        }
        throw new RuntimeException("Incorrect incoming expression.");
    }

    /*
     * метод вычисления выражения (как в условии)
     * вызываем метод getCalculator и передаем в параметры выражение
     * так как метод getCalculator возвращает объект типа Calculator
     * то вызываем у него метод getResult, который вернет нам результат вычислений,
     * какого типа будет результат, зависит от того в каком формате будет строка
     * ввода(римские/арабские цифры)
     */
    static String calc(String input) {
        return getCalculator(input).getResult();
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);) {
            while (true) {
                String input = scanner.nextLine();
                String result = calc(input);
                System.out.println("Output:\n" + result);
            }
        }
    }
}