package ru.shirshin;

/*
* класс AbstractCalculator
* @param calculations - массив всех вычислений
 */
abstract class AbstractCalculator {

    protected Calculation[] calculations;

    /**
     * в конструкторе инициализируем массив калькуляторов 
     * и добавляем все классы отвечающие за операции вычислений
     */
    public AbstractCalculator() {
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

