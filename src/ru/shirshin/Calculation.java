package ru.shirshin;

/**
 * Интерфейс, Calculation(Вычисление)
 */
interface Calculation {

    /**
     * метод, операция каких либо вычислений вычисления
     * @param firstNum - первое число
     * @param secondNum - второе число
     * @return - возвращает целочисленное значение (int)
     */
    int operation(int firstNum, int secondNum);
}