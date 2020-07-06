package com.mark.concurrent01;

public class Accessment implements Cloneable, Comparable<Accessment> {
    int value = 1;

    public static void main(String[] args) throws CloneNotSupportedException {
        Accessment a = new Accessment();
        Accessment b = change1(a);
        Accessment c = change2(b);
        System.out.println((a == b) + "," +
                (a == c) + "," +
                (b == c) + "," +
                a.equals(c));
    }

    static Accessment change2(Accessment b) throws CloneNotSupportedException {
        Accessment result = (Accessment) b.clone();
        return result;
    }

    static Accessment change1(Accessment a) {
        a.setValue(2);
        return a;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int compareTo(Accessment o) {
        return this.value - o.value;
    }

    public boolean equals(Object obj) {
        return this.compareTo((Accessment) obj) == 0;

    }
}