package com.task2.ch1;

import java.util.Scanner;

public class Ex4 {
    public static void doIt() {
        double v = Math.nextUp(Double.MAX_VALUE);
        System.out.println(v);
        System.out.println("MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("MAX_VALUE neg: " + -Double.MAX_VALUE);
        System.out.println("MIN_VALUE: " + Math.nextDown(-Double.MAX_VALUE));
        System.out.println(Math.nextUp(0.0));
        System.out.println(Math.nextUp(-1.0));
    }
}
