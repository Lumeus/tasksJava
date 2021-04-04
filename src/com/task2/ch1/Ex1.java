package com.task2.ch1;

import java.util.Scanner;

public class Ex1 {
    public static void doIt() {
        System.out.print("Enter integer: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(10);
        System.out.println("Binary: " + Integer.toString(num, 2));
        System.out.println("Octal: " + Integer.toString(num, 8));
        System.out.println("Hexadecimal: " + Integer.toString(num, 16));
        System.out.println("Reciprocal: " + 1.0/num);
        System.out.println("Hexadecimal reciprocal: " + Double.toHexString(1.0/num));
    }
}
