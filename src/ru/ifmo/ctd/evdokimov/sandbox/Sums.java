package ru.ifmo.ctd.evdokimov.sandbox;

public class Sums {
    public static int sum(int a, int b) {
        return a + b;
    }

    private static int xxx = 10;

    private int yyy = 100;

    public static int sum2(int a, int b) {
        return sum(a, xxx);
    }

    public static void print(int x) {
        boolean a = true;
        byte b = 2;
        short s = 300;
        int i = 200000000;
    }


    public static void bar(int n) {
        int i = 0;
        while (i < n) {
            int t = i * 10;
            i = i + 1;
        }
    }

    public static void foo(int x) {
        int i = 1111;
        if (x > 100) {
            int z = 400;
        } else {
            int y = 300;
            int yy = 17;
        }
        int zz = 0;
    }

    public static void main(String[] args) {
//        int x = 100;
//        int y = 200;
//        int z = 300;
//
//        int i = sum(x, y);
//        int j = sum(x, z);
//        int k = sum(y, z);

//        int i = 0;
//        while (i < 5) {
//            int t = i * 10;
//            System.out.println(t);
//            i = i + 1;
//        }

//        int x = 400;
//        int y = 5;
//        int z = x + y;
//        System.out.println(z);

        boolean x = true;


    }
}


