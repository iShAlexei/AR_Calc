package ru.shirshin;

/*
* абстрактный класс Calculator
* @param Calculation - массив всех вычислений
 */
abstract class Calculator {

    protected Calculation[] calculations;

    /**
     * в конструкторе инициализируем массив калькуляторов 
     * и добавляем все классы отвечающие за операции вычислений
     */
    public Calculator() {
        calculations = new Calculation[]{
            new Summa(), 
            new Subtract(), 
            new Multiply(), 
            new Division()};
    }

    protected abstract String getResult();

    public Calculation[] getCalculator() {
        return calculations;
    }
}

