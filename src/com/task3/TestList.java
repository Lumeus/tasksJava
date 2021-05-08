package com.task3;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class TestList {

    static int[] myResult;
    static int[] linkedResult;
    static int[] arrayResult;

    public static void main() {

        MyLinkedList<Integer> myList = new MyLinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();


        myResult = Arrays.stream(testList(myList, 10000, 100)).mapToInt((x) -> { return (int) x; }).toArray();
        linkedResult = Arrays.stream(testList(linkedList, 10000, 100)).mapToInt((x) -> { return (int) x; }).toArray();
        arrayResult = Arrays.stream(testList(arrayList, 10000, 100)).mapToInt((x) -> { return (int) x; }).toArray();
        System.out.println("\r" + Arrays.toString(myResult));
        System.out.println(Arrays.toString(linkedResult));
        System.out.println(Arrays.toString(arrayResult));
//        myResult = new int[]{0, 0, 0, 0, 0, 0};
//        linkedResult = new int[]{0, 0, 0, 0, 0, 0};
//        arrayResult = new int[]{0, 0, 0, 0, 0, 0};



        JFrame frame = new JFrame("Сравнение реализаций списков");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas(){
            @Override
            public void paint(Graphics g){
                final int[] i = {0};
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, 500, 600);
                g.setColor(Color.BLACK);
                // Отрисовка клеточек
                g.drawPolyline(
                        new int[]{50, 400, 400, 50,  50,
                                100, 100, 150, 150, 200, 200, 250, 250, 300, 300, 350, 350,
                                400,
                                400,  50,  50, 400, 400,  50,  50, 400, 400,  50,  50, 400},
                        new int[]{50, 50, 400, 400,  50,
                                 50, 400, 400,  50,  50, 400, 400,  50,  50, 400, 400,  50,
                                50,
                                100, 100, 150, 150, 200, 200, 250, 250, 300, 300, 350, 350},
                        30);
                g.drawString("100", 25, 355);
                g.drawString("200", 25, 305);
                g.drawString("300", 25, 255);
                g.drawString("400", 25, 205);
                g.drawString("500", 25, 155);
                g.drawString("600", 25, 105);
                g.drawString("ms", 30, 55);
                g.drawString("add", 92, 415);
                g.drawString("add with", 130, 415);
                g.drawString("index", 137, 425);
                g.drawString("get", 192, 415);
                g.drawString("indexOf", 230, 415);
                g.drawString("remove", 280, 415);
                g.drawString("set", 342, 415);
                Arrays.stream(myResult).map(x -> x / 1000).forEach(x -> {
                    g.drawString(String.valueOf(x), 92 + (i[0] * 50), 450);
                    i[0]++;
                });
                i[0] = 0;
                Arrays.stream(linkedResult).map(x -> x / 1000).forEach(x -> {
                    g.drawString(String.valueOf(x), 92 + (i[0] * 50), 475);
                    i[0]++;
                });
                i[0] = 0;
                Arrays.stream(arrayResult).map(x -> x / 1000).forEach(x -> {
                    g.drawString(String.valueOf(x), 92 + (i[0] * 50), 500);
                    i[0]++;
                });
                g.setColor(Color.RED);
                g.drawString("MyLinkedList", 15, 450);
                g.drawPolyline(new int[]{100, 150, 200, 250, 300, 350},
                        Arrays.stream(myResult).map(x -> 400 - x / 2000000).toArray(),
                        6);
                g.setColor(Color.BLUE);
                g.drawString("LinkedList", 15, 475);
                g.drawPolyline(new int[]{100, 150, 200, 250, 300, 350},
                        Arrays.stream(linkedResult).map(x -> 400 - x / 2000000).toArray(),
                        6);
                g.setColor(Color.YELLOW);
                g.drawString("ArrayList", 15, 500);
                g.drawPolyline(new int[]{100, 150, 200, 250, 300, 350},
                        Arrays.stream(arrayResult).map(x -> 400 - x / 2000000).toArray(),
                        6);
            }
        };
        frame.add(canvas);
        frame.setVisible(true);

    }



    static void printLine(int percent) {
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        while (i < percent){
            builder.append('=');
            i++;
        }
        while (i < 100){
            builder.append(' ');
            i++;
        }
        builder.append(']');
        System.out.print("\r" + builder.toString());
    }




    static double[] testList(List<Integer> l, int n, int m){
        double[] res = new double[6];
        long[] add = new long[m];
        long[] addWithIndex = new long[m];
        long[] get = new long[m];
        long[] indexOf = new long[m];
        long[] remove = new long[m];
        long[] set = new long[m];
        for (int i = 0; i < m; i++){
            add[i] = testListAdd(l, n);
//            System.out.println(i + " : " + 1);
            addWithIndex[i] = testListAddWidthIndex(l, n);
//            System.out.println(i + " : " + 2);
            get[i] = testListGet(l, n);
//            System.out.println(i + " : " + 3);
            indexOf[i] = testListIndexOf(l, n);
//            System.out.println(i + " : " + 4);
            set[i] = testListSet(l, n);
//            System.out.println(i + " : " + 5);
            remove[i] = testListRemove(l, n);
//            System.out.println(i + " : " + 6);
            testListRemove(l, n);
            printLine((i * 100) / m);
        }
        res[0] = Arrays.stream(add).average().getAsDouble();
        res[1] = Arrays.stream(addWithIndex).average().getAsDouble();
        res[2] = Arrays.stream(get).average().getAsDouble();
        res[3] = Arrays.stream(indexOf).average().getAsDouble();
        res[4] = Arrays.stream(remove).average().getAsDouble();
        res[5] = Arrays.stream(set).average().getAsDouble();
        return res;
    }

    static double[] testList(MyLinkedList<Integer> l, int n, int m){
        double[] res = new double[6];
        long[] add = new long[m];
        long[] addWithIndex = new long[m];
        long[] get = new long[m];
        long[] indexOf = new long[m];
        long[] remove = new long[m];
        long[] set = new long[m];
        for (int i = 0; i < m; i++){
            add[i] = testListAdd(l, n);
//            System.out.println(i + " : " + 1);
            addWithIndex[i] = testListAddWidthIndex(l, n);
//            System.out.println(i + " : " + 2);
            get[i] = testListGet(l, n);
//            System.out.println(i + " : " + 3);
            indexOf[i] = testListIndexOf(l, n);
//            System.out.println(i + " : " + 4);
            set[i] = testListSet(l, n);
//            System.out.println(i + " : " + 5);
            remove[i] = testListRemove(l, n);
//            System.out.println(i + " : " + 6);
            testListRemove(l, n);
            printLine((i * 100) / m);
        }
        res[0] = Arrays.stream(add).average().getAsDouble();
        res[1] = Arrays.stream(addWithIndex).average().getAsDouble();
        res[2] = Arrays.stream(get).average().getAsDouble();
        res[3] = Arrays.stream(indexOf).average().getAsDouble();
        res[4] = Arrays.stream(remove).average().getAsDouble();
        res[5] = Arrays.stream(set).average().getAsDouble();
        return res;
    }

    static long testListAdd(List<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.add(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListAddWidthIndex(List<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.add(i, i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListGet(List<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.get(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListIndexOf(List<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.indexOf(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListRemove(List<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = n-1; i >= 0; i--){
            l.remove(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListSet(List<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.set(i, i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListAdd(MyLinkedList<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.add(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListAddWidthIndex(MyLinkedList<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.add(i, i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListGet(MyLinkedList<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.get(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListIndexOf(MyLinkedList<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.indexOf(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListRemove(MyLinkedList<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = n-1; i >= 0; i--){
            l.remove(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testListSet(MyLinkedList<Integer> l, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            l.set(i, i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }
}
