package ru.shirshin;

/**
 * перечисление RomainDigits, сопоставляет римские числа с арабскими
 */
enum RomainDigits {

    I("I",1), 
    V("V", 5), 
    X("X", 10), 
    L("L", 50), 
    C("C", 100);

    private String romain;
    private int arabian;

    RomainDigits(String romain, int arabian) {
        this.romain = romain;
        this.arabian = arabian;
    }

    public String getRomain() {
        return romain;
    }

    public int getArabian() {
        return arabian;
    }
}
