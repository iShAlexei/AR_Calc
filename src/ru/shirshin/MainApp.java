package ru.shirshin;

import java.util.Scanner;

public class MainApp {

    /*
     * метод проверяет, какие вычисления выполняет пользователь
     * примеры выражений допустимых для ввода:
     *
     * I+I         1+1
     * V -I        1 -5
     * II* VI      5* 3
     * VI / II     4 / 2
     *
     * если входящее выражение соответствует шаблону в регулярном выражении,
     * то создаем объект и передаем в параметры выражение,
     * если выражение не соответствует ни одному условию, бросаем исключение.
     */
    static AbstractCalculator getCalculator(String input) {
        if (input.matches("^([IVX]+)(\\s|)[/*+-](\\s|)([IVX]+)$")) {
            return new RomainCalculator(input);
        }
        if (input.matches("^([1-9]|10)(\\s|)[/*+-](\\s|)([1-9]|10)$")) {
            return new ArabianCalculator(input);
        }
        throw new RuntimeException("Incorrect incoming expression.");
    }

    /**
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
                System.out.print("Input: ");

                String result = calc(scanner.nextLine());

                System.out.println("Output:\n" + result);
            }
        }
    }
}