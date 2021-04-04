package com.task2.ch1;

import java.util.ArrayList;

public class Ex13 {
    public static void doIt() {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        int index;
        for (int i = 1; i < 50; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < 6; i++) {
            index = (int)(Math.random() * (49 - i));
            sortedInsert(combination, numbers.remove(index));
        }
        System.out.println(combination);
    }

    public static void sortedInsert(ArrayList<Integer> arr, int num) {
        int temp;
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) > num) {
                temp = arr.get(i);
                arr.set(i, num);
                num = temp;
            }
        }
        arr.add(num);
    }
}
