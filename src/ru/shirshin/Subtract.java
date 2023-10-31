package ru.shirshin;

/**
 * класс, операция вычитания, реализует интерфейс Calculation
 */
class Subtract implements Calculation {

    @Override
    public int operation(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }
}
