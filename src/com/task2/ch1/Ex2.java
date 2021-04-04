package com.task2.ch1;

import java.util.Scanner;

public class Ex2 {
    public static void doIt() {
        System.out.print("Enter integer: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt(10);
        System.out.println("%: " + (num % 360 + 360) % 360);
        System.out.println("floorMod: " + Math.floorMod(num, 360));
    }
}
