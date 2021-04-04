package com.task2.ch3;

public interface Measurable {
    double getMeasure();

    static double average(Measurable[] objects) {
        double res = 0.0;
        for (Measurable object : objects) {
            res += object.getMeasure();
        }
        return res / objects.length;
    }

    static Measurable largest(Measurable[] objects) {
        Measurable largest = objects[0];
        for (Measurable object : objects) {
            if (largest.getMeasure() < object.getMeasure()) largest = object;
        }
        return largest;
    }
}
