package com.task2.ch2;

public class MyPoint {
    private double x = 0;
    private double y = 0;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public MyPoint translate(double x, double y) {
        return new MyPoint(this.x + x, this.y + y);
    }

    public MyPoint scale(double k) {
        return new MyPoint(this.x * k, this.y * k);
    }
}
