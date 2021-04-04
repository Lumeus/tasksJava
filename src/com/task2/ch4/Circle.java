package com.task2.ch4;

import com.task2.ch2.MyPoint;

public class Circle extends Shape {
    private double radius;

    public Circle(MyPoint point, double radius) {
        super(point);
        this.radius = radius;
    }

    @Override
    public MyPoint getCenter() {
        return point;
    }

    public Circle clone() throws CloneNotSupportedException {
        Circle clone = (Circle) super.clone();
        clone.radius = this.radius;
        return clone;
    }
}
