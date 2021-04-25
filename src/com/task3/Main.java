package com.task3;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList1 = new MyLinkedList<>();
        for (int i = 0; i < 1000; i++){
            myList1.add(i);
        }
        System.out.println(myList1.size());
        System.out.println(myList1.toString());
        myList1.clear();
        myList1.add(4);
        try {
            myList1.add(4, 5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("!!!!!!!!!!!!!");
        }
        System.out.println(myList1.size());
        System.out.println(myList1.toString());
        myList1.clear();
        System.out.println(myList1.size());
        System.out.println(myList1.toString());
    }
}
