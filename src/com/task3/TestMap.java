package com.task3;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class TestMap {

    static int[] hashResult;
    static int[] linkedResult;
    static int[] treeResult;

    public static void main() {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();


        hashResult = Arrays.stream(testMap(hashMap, 10000, 1000)).mapToInt((x) -> { return (int) x; }).toArray();
        linkedResult = Arrays.stream(testMap(linkedMap, 10000, 1000)).mapToInt((x) -> { return (int) x; }).toArray();
        treeResult = Arrays.stream(testMap(treeMap, 10000, 1000)).mapToInt((x) -> { return (int) x; }).toArray();
        System.out.println("\r" + Arrays.toString(hashResult));
        System.out.println(Arrays.toString(linkedResult));
        System.out.println(Arrays.toString(treeResult));



        JFrame frame = new JFrame("Сравнение реализаций \"карт\"");
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
                g.drawString("0,2", 25, 355);
                g.drawString("0,4", 25, 305);
                g.drawString("0,6", 25, 255);
                g.drawString("0,8", 25, 205);
                g.drawString("1,0", 25, 155);
                g.drawString("1,2", 25, 105);
                g.drawString("ms", 30, 55);
                g.drawString("put", 142, 415);
                g.drawString("get", 242, 415);
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
                g.drawString("HashMap", 15, 450);
                g.drawPolyline(new int[]{150, 250, 350},
                        Arrays.stream(hashResult).map(x -> 400 - x / 4000).toArray(),
                        3);
                g.setColor(Color.BLUE);
                g.drawString("LinkedHashMap", 15, 475);
                g.drawPolyline(new int[]{150, 250, 350},
                        Arrays.stream(linkedResult).map(x -> 400 - x / 4000).toArray(),
                        3);
                g.setColor(Color.YELLOW);
                g.drawString("TreeMap", 15, 500);
                g.drawPolyline(new int[]{150, 250, 350},
                        Arrays.stream(treeResult).map(x -> 400 - x / 4000).toArray(),
                        3);
            }
        };
        frame.setLocation(1000, 0);
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



    static double[] testMap(Map<Integer, Integer> s, int n, int m){
        double[] res = new double[3];
        long[] add = new long[m];
        long[] contain = new long[m];
        long[] remove = new long[m];
        for (int i = 0; i < m; i++){
            add[i] = testMapPut(s, n);
//            System.out.println(i + " : " + 1);
            contain[i] = testMapGet(s, n);
//            System.out.println(i + " : " + 2);
            remove[i] = testMapRemove(s, n);
//            System.out.println(i + " : " + 3);
            printLine((i * 100) / m);
        }
        res[0] = Arrays.stream(add).average().getAsDouble();
        res[1] = Arrays.stream(contain).average().getAsDouble();
        res[2] = Arrays.stream(remove).average().getAsDouble();
        return res;
    }



    static long testMapPut(Map<Integer, Integer> s, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            s.put(i, i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testMapGet(Map<Integer, Integer> s, int n){
        Instant start = Instant.now();
        for (int i = 0; i < n; i++){
            s.get(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }

    static long testMapRemove(Map<Integer, Integer> s, int n){
        Instant start = Instant.now();
        for (int i = n-1; i >= 0; i--){
            s.remove(i);
        }
        Instant finish = Instant.now();
        return Duration.between(start, finish).toNanos();
    }
}
