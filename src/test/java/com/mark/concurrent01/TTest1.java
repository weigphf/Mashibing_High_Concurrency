package com.mark.concurrent01;

/**
 * Created by develop on 2020/3/2.
 */
public class TTest1 {
    public static void main(String[] args) {
        Integer i = 123;
        Long j = 123L;
        boolean x = i.equals(j);
        System.out.println(i.equals(j));

        System.out.println(test(4));


        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        char d[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(d));
    }

    public static int test(int b) {
        int a = (int) Math.floor(b);
        return a;
    }
}
