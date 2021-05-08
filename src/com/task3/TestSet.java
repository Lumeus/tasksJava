package com.task3;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class TestSet {

    static int[] hashResult;
    static int[] linkedResult;
    static int[] treeResult;

    public static void main() {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();


        hashResult = Arrays.stream(testSet(hashSet, 10000, 1000)).mapToInt((x) -> { return (int) x; }).toArray();
        linkedResult = Arrays.stream(testSet(linkedSet, 10000, 1000)).mapToInt((x) -> { return (int) x; }).toArray();
        treeResult = Arrays.stream(testSet(treeSet, 10000, 1000)).mapToInt((x) -> { return (int) x; }).toArray();
        System.out.println("\r" + Arrays.toString(hashResult));
        System.out.println(Arrays.toString(linkedResult));
        System.out.println(Arrays.toString(treeResult));



        JFrame frame = new JFrame("Сравнение реализаций множеств");
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
                g.drawString("0,25", 25, 355);
                g.drawString("0,50", 25, 305);
                g.drawString("0,75", 25, 255);
                g.drawString("1,00", 25, 205);
                g.drawString("1,25", 25, 155);
                g.drawString("1,50", 25, 105);
                g.drawString("ms", 30, 55);
                g.drawString("add", 142, 415);
                g.drawString("contain", 230, 415);
                g.drawString("remove", 330, 415);
                Arrays.stream(hashResult).map(x -> x / 1000).forEach(x -> {
                    g.drawString(String.valueOf(x), 142 + (i[0] * 100), 450);
                    i[0]++;
                });
                i[0] = 0;
                Arrays.stream(linkedResult).map(x -> x / 1000).forEach(x -> {
                    g.drawString(String.valueOf(x), 142 + (i[0] * 100), 475);
                    i[0]++;
                });
                i[0] = 0;
                Arrays.stream(treeResult).map(x -> x / 1000).forEach(x -> {
                    g.drawString(String.valueOf(x), 142 + (i[0] * 100), 500);
                    i[0]++;
                });
                g.setColor(Color.RED);
                g.drawString("HashSet", 15, 450);
                g.drawPolyline(new int[]{150, 250, 350},
                        Arrays.stream(hashResult).map(x -> 400 - x / 5000).toArray(),
                        3);
                g.setColor(Color.BLUE);
                g.drawString("LinkedHashSet", 15, 475);
                g.drawPolyline(new int[]{150, 250, 350},
                        Arrays.stream(linkedResult).map(x -> 400 - x / 5000).toArray(),
                        3);
                g.setColor(Color.YELLOW);
                g.drawString("TreeSet", 15, 500);
                g.drawPolyline(new int[]{150, 250, 350},
                        Arrays.stream(treeResult).map(x -> 400 - x / 5000).toArray(),
                        3);
            }
        };
        frame.setLocation(500, 0);
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



    static double[] testSet(Set<Integer> s, int n, int m){
        double[] res = new double[3];
        long[] add = new long[m];
        long[] contain = new long[m];
        long[] remove = new long[m];
        for (int i = 0; i < m; i++){
            add[i] = testSetAdd(s, n);
//            System.out.println(i + " : " + 1);
            contain[i] = testSetContain(s, n);
//            System.out.println(i + " : " + 2);
            remove[i] = testSetRemove(s, n);
//            System.out.println(i + " : " + 3);
            printLine((i * 100) / m);
        }
        res[0] = Arrays.stream(add).average().getAsDouble();
        res[1] = Arrays.stream(contain).average().getAsDouble();
        res[2] = Arrays.stream(remove).average().getAsDouble();
        return res;
    }



    static long testSetAdd(Set<Integer> s, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            s.add(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testSetContain(Set<Integer> s, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            s.contains(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testSetRemove(Set<Integer> s, int n){
        Instant start = Instant.now();
        for (int i = n-1; i >= 0; i--){
            s.remove(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }
}
