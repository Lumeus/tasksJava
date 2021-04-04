package com.task2.ch2;

public class MyPointMutator {
    private double x = 0;
    private double y = 0;

    public MyPointMutator() {
    }

    public MyPointMutator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void scale(double k) {
        this.x *= k;
        this.y *= k;
    }
}
