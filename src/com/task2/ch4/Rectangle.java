package com.task2.ch4;

import com.task2.ch2.MyPoint;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(MyPoint topLeft, double width, double length) {
        super(topLeft);
        this.width = width;
        this.length = length;
    }

    @Override
    public MyPoint getCenter() {
        return point.translate(width/2, length/2);
    }

    public Rectangle clone() throws CloneNotSupportedException {
        Rectangle clone = (Rectangle) super.clone();
        clone.length = this.length;
        clone.width = this.width;
        return clone;
    }
}
