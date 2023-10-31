package ru.shirshin;

/**
 * класс ArabianCalculator, наследует класс Calculator,
 * описывает вычисления с помощью арабских чисел
 */
class ArabianCalculator extends Calculator {

    public ArabianCalculator() {
    }

    /**
     * переопределенный метод, выполняет вычисления из выражения
     * переданного в параметры конструктора класса
     * @return String(результат вычислений)
     */
    @Override
    public String getResult(String expression) {
        int result = 0;
        String[] array = expression.split("\\s*[/*+-]\\s*"); // разделяем выражение по знакам действий
        int firstNumber = Integer.parseInt(array[0]);
        int secondNumber = Integer.parseInt(array[1]);

        /**
         * проверяем какой знак действия содержит выражение
         * так как в конструкторе родительского класса проинициализирован массив
         * со всеми классами вычислений, 
         * то получаем объект класса вычислений из массива, вызываем метод operation, 
         * передаем в параметры первое и второе число
         */
        if (expression.contains("+")) {
            result = calculations[0].operation(firstNumber, secondNumber);
        }
        if (expression.contains("-")) {
            result = calculations[1].operation(firstNumber, secondNumber);
        }
        if (expression.contains("*")) {
            result = calculations[2].operation(firstNumber, secondNumber);
        }
        if (expression.contains("/")) {
            result = calculations[3].operation(firstNumber, secondNumber);
        }

        return String.valueOf(result);
    }
}