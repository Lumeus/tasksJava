package com.task2.ch1;

import sun.awt.geom.AreaOp;

import java.util.Scanner;

public class Ex3 {
    public static void doIt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter integer: ");
        int num1 = in.nextInt(10);
        System.out.print("Enter integer: ");
        int num2 = in.nextInt(10);
        System.out.print("Enter integer: ");
        int num3 = in.nextInt(10);

        int max1 = num1;
        if (max1 < num2) max1 = num2;
        if (max1 < num3) max1 = num3;

        int max2 = Math.max(Math.max(num1, num2), num3);

        System.out.println("Max by conditional operator: " + max1);
        System.out.println("Max by Math.max: " + max2);
    }
}
