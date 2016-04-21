package ru.ifmo.ctd.evdokimov.sandbox;

import java.util.Scanner;

public class Read {
    private static Scanner _sc;

    public Read() {
    }

    private static void main() {
        int var0 = _sc.nextInt();
        boolean var1 = _sc.nextBoolean();
    }

    public static void main(String[] var0) {
        main();
    }

    static {
        _sc = new Scanner(System.in);
    }
}