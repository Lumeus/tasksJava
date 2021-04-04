package com.task2.ch4;

import com.task2.ch2.MyPoint;

public class Line extends Shape {
    private MyPoint to;

    public Line(MyPoint from, MyPoint to) {
        super(from);
        this.to = to;
    }

    @Override
    public void moveBy(double x, double y) {
        super.moveBy(x, y);
        to.translate(x, y);
    }

    @Override
    public MyPoint getCenter() {
        return point.translate(to.getX()/2, to.getY()/2);
    }

    public Line clone() throws CloneNotSupportedException {
        Line clone = (Line) super.clone();
        clone.to = new MyPoint(this.to.getX(), this.to.getY());
        return clone;
    }
}
