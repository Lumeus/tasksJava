package com.task1.otherTasks;

public class Ball {
    private double x;
    private double y;
    private int radius;
    private double xDelta;
    private double yDelta;

    public Ball(double x, double y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = speed * Math.cos(direction);
        this.yDelta = speed * Math.sin(direction);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getxDelta() {
        return xDelta;
    }

    public void setxDelta(double xDelta) {
        this.xDelta = xDelta;
    }

    public double getyDelta() {
        return yDelta;
    }

    public void setyDelta(double yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" +
                x + ", " + y +
                "), speed = (" +
                xDelta + ", " + yDelta +
                ")]";
    }
}
