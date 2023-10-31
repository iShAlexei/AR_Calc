package ru.shirshin;

/**
 * класс, операция сложения, реализует интерфейс Calculation
 */
class Summa implements Calculation {

    @Override
    public int operation(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
