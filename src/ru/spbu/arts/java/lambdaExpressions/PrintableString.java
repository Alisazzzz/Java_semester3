package ru.spbu.arts.java.lambdaExpressions;

public class PrintableString implements Printable{

    private String str;

    public PrintableString(String s) {
        this.str = s;
    }

    @Override
    public void print() {
        System.out.println(str);
    }
}
