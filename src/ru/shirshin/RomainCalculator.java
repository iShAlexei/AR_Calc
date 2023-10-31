package ru.shirshin;

/*
 * класс, наследует класс AbstractCalculator,
 * описывает вычисления с помощью римских чисел
 */
public class RomainCalculator extends AbstractCalculator {

    private String expression;

    RomainCalculator(String expression) {
        this.expression = expression;
    }

    /*
     * переопределенный метод, выполняет вычисления из выражения переданного в параметры конструктора класса
     */
    @Override
    public String getResult() {
        int result = 0;

        String[] expressionArray = expression.split("\\s*[/*+-]\\s*"); // разделяем входящее выражение по знакам действий и пробелам

        int firstNumber = 0;
        int secondNumber = 0;

        for (int i = 0; i < expressionArray.length; i++) {
            String[] romainDigitArray = expressionArray[i].split("");   // разделяем полученные строки
            if (i == 0) {
                firstNumber = romainToArabian(romainDigitArray); // первое число
            } else {
                secondNumber = romainToArabian(romainDigitArray); // второе число
            }
        }

        /*
         * проверяем какой знак действия содержит выражение
         * так как в конструктор родительского класса, принимает в массив все классы вычислений,
         * получаем объект класса вычислений из массива, вызываем метод action, передаем в параметры первое и второе число
         */
        if (expression.contains("+")) {
            result = calculations[0].operation(firstNumber, secondNumber);
        }

        if (expression.contains("-")) {

            // проверка для выполнения условия задачи вывод значений больше 0
            if (firstNumber - secondNumber <= 0) {
                throw new ArithmeticException("Incorrect operation subtract with Romain Digits");
            }
            result = calculations[1].operation(firstNumber, secondNumber);
        }

        if (expression.contains("*")) {
            result = calculations[2].operation(firstNumber, secondNumber);
        }

        if (expression.contains("/")) {

            // проверка для выполнения условия задачи вывод значений больше 0
            if (firstNumber < secondNumber) {
                throw new ArithmeticException("Incorrect operation division with Romain Digits");
            }
            result = calculations[3].operation(firstNumber, secondNumber);
        }

        return arabianToRomain(result); // обратная конвертация в римские числа
    }

    /*
     * метод, выполняет конвертацию римских цифр в арабские
     * метод нужен для выполнения вычислений с числами
     * @param array - в аргумент передаем римское число в виде массива строк
     * @return - возвращаем в обычном(арабском) виде число
     */
    private int romainToArabian(String[] array) {
        int number = 0;
        for (int i = 0; i < array.length; i++) {

            /*
            * получаем число из enum
            * метод valueOf с параметрами из массива, вернет соответствующий объект enum
            * firstRD.getArabian() - получаем число соответствующее значению
            */
            RomainDigits firstRD = RomainDigits.valueOf(RomainDigits.class, array[i]);
            int first = firstRD.getArabian();

            int second = 0;

            // проверка для чисел 4 и 9, для этого ввели еще одну переменную
            if (array.length > i + 1) {
                RomainDigits secondRD = RomainDigits.valueOf(RomainDigits.class, array[i + 1]);
                second = secondRD.getArabian();
            }
            // проверка для чисел 4 и 9, для этого ввели еще одну переменную
            if (first < second) {
                if (array[i].equals(firstRD.getRomain())) {
                    return checkInputValueMore10(second - first);
                }
            } else {
                // если первое условие не выполняется просто складываем все полученные из массива числа
                if (array[i].equals(firstRD.getRomain()) && array.length <= 2) {
                    return checkInputValueMore10(second + first);
                } else if (array[i].equals(firstRD.getRomain())) {
                    number += first;
                }
            }
        }
        return checkInputValueMore10(number);
    }

    /*
    * Метод, проверка по условию задания, "входящее числа больше 10 недопустимы"
     */
    private int checkInputValueMore10(int number) {
        if (number > 10) {
            throw new RuntimeException("Incorrect value, an incoming number greater than 10");
        } else {
            return number;
        }
    }

    /*
     * метод, обратная конвертация из римских в арабские
     * нужен для получения результата вычисления
     */
    private String arabianToRomain(int number) {

        StringBuilder str = new StringBuilder();

        int count = 0;

        int identicalNumbersCounter = 1; // счетчик одинаковых чисел типа: IIII, XXXX, VIIII

        RomainDigits[] romainDigits = RomainDigits.values();    // получаем массив всех перечислений

        int i = romainDigits.length - 1;    // переменная для прохода массива enum с конца

        while (count < romainDigits.length) {

            // последовательно с конца массива enum проходим по всем значениям и выполняем проверку
            if (number / romainDigits[i].getArabian() != 0) {
                str.append(romainDigits[i].getRomain()); // если условие верно добавляем римское число в объект StringBuilder
                number -= romainDigits[i].getArabian(); // вычитаем найденное число из входящего числа
                identicalNumbersCounter++;

                if (identicalNumbersCounter == 4) { // проверка на числа с цифрами 4 и 9 в десятках и единицах

                    /*
                    * если находим совпадение в строке определяем индексы совпадения,
                    * удаляем по найденным индексам,
                    * затем вставляем с индекса первого найденного символа указанную строку
                     */
                    if (str.toString().contains("VIIII")) {
                        int firstIndex = str.indexOf("V");
                        int lastIndex = str.lastIndexOf("I");
                        str.delete(firstIndex, lastIndex + 1);
                        str.insert(firstIndex, "IX");
                    }
                    if (str.toString().contains("IIII")) {
                        int firstIndex = str.indexOf("I");
                        int lastIndex = str.lastIndexOf("I");
                        str.delete(firstIndex, lastIndex + 1);
                        str.insert(firstIndex, "IV");
                    }
                    if (str.toString().contains("XXXX")) {
                        int firstIndex = str.indexOf("X");
                        int lastIndex = str.lastIndexOf("X");
                        str.delete(firstIndex, lastIndex + 1);
                        str.insert(firstIndex, "XL");
                    }
                    if (str.toString().contains("LXL")) {
                        int firstIndex = str.indexOf("L");
                        int lastIndex = str.lastIndexOf("L");
                        str.delete(firstIndex, lastIndex + 1);
                        str.insert(firstIndex, "XC");
                    }
                    identicalNumbersCounter = 0;
                }
                continue;
            }
            identicalNumbersCounter = 0;
            i--;
            count++;
        }
        return str.toString();
    }
}