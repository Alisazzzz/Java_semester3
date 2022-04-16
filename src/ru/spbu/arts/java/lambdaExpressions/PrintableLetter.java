package ru.spbu.arts.java.lambdaExpressions;

public class PrintableLetter implements Printable{

    private String symbol;
    private int amount;

    public PrintableLetter(String c, int x) {
        this.symbol = c;
        this.amount = x;
    }

    @Override
    public void print() {
        System.out.println(symbol.repeat(amount));
    }
}
