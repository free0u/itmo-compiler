package ru.ifmo.ctd.evdokimov.alang;

public class Power {
    public static void main(String[] args) {
        int k;
        int n;
        int r;
        n = 2;
        k = 10;
        r = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                r = r * n;
            } else {
            }
            n = n * n;
            k = k / 2;
        }
        System.out.println(r);
    }

}
