package ru.shirshin;

/**
 * класс, операция умножения, реализует интерфейс Calculation
 */
class Multiply implements Calculation {

    @Override
    public int operation(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}