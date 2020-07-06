package com.mark.concurrent01;

public class RuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.print("A");
        } catch (RuntimeException ex) {
            System.out.print("B");
        } catch (Exception ex1) {
            System.out.print("C");
        } finally {
            System.out.print("D");
        }
        System.out.print("E");

    }

    public static void badMethod() {
        throw new RuntimeException();
    }

    public class ReturnData {
        double getData(byte a, double z) {
            return (a / z) * 10;
        }
    }
}