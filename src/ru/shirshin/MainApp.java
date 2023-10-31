package ru.shirshin;

import java.util.Scanner;

public class MainApp {

    static String calc(String input) {
        return input;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Output:\n" + result);
        }

    }
}