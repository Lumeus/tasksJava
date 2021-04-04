package com.task2.ch1;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex6 {
    public static void doIt() {
        System.out.print("Enter integer: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(10);
        System.out.println("fact: " + fact(num));
    }

    public static BigInteger fact(int x){
        BigInteger res = BigInteger.valueOf(x);
        if (x > 1) {
            res = res.multiply(fact(x -1));
        }
        return res;
    }
}
