package ru.shirshin;

/**
 * класс, операция деления, реализует интерфейс Calculation
 */
class Division implements Calculation {

    @Override
    public int operation(int firstNum, int secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstNum / secondNum;
    }
}