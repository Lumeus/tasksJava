package com.task2.ch4;

import com.task2.ch2.MyPoint;

public abstract class Shape implements Cloneable{
    protected MyPoint point;

    public Shape(MyPoint point) {
        this.point = point;
    }

    public void moveBy(double x, double y) {
        point.translate(x, y);
    }

    public abstract MyPoint getCenter();

    public Shape clone() throws CloneNotSupportedException {
        Shape clone = (Shape) super.clone();
        clone.point = new MyPoint(this.point.getX(), this.point.getY());
        return clone;
    }
}
