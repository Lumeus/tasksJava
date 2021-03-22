package com.task1;

import com.task1.geometry.Circle;
import com.task1.geometry.MyPoint;
import com.task1.geometry.MyTriangle;
import com.task1.geometry.Rectangle;
import com.task1.math.MyComplex;
import com.task1.math.MyPolynomial;
import com.task1.otherTasks.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println("--------------------------work with a circle--------------------------------------------");
        Circle circle = new Circle(15.5, "green");
        System.out.println(circle);
        System.out.println("Area = "  +  circle.getArea());

        System.out.println("--------------------------work with a rectangle-----------------------------------------");
        Rectangle rectangle = new Rectangle(13.5f, 4.6f);
        System.out.println(rectangle);
        System.out.println("Area = "  +  rectangle.getArea());
        System.out.println("Perimeter = "  +  rectangle.getPerimeter());

        System.out.println("--------------------------work with a employee------------------------------------------");
        Employee employee = new Employee(1234, "Bruce", "Wayne", 123);
        System.out.println(employee);
        System.out.println("raiseSalary(12) = " + employee.raiseSalary(-12));//123*1.12=137.76

        System.out.println("--------------------------work with a book----------------------------------------------");
        Author[] authors = {new Author("Boris", "@Boris", 'm'),
                new Author("Gleb", "@Gleb", 'm')};
        Book book = new Book("silmarillion", authors, 123, 12);
        System.out.println(book);
        System.out.println(book.getAuthorNames());

        System.out.println("--------------------------work with a point---------------------------------------------");
        MyPoint point = new MyPoint(2.2, 3.3);
        System.out.println("distance from point" +  point + " to start = " + point.distance());

        System.out.println("--------------------------work with a triangle------------------------------------------");
        MyTriangle triangle = new MyTriangle(0, 0, 1, 1, 2, 0);
        System.out.println(triangle);
        System.out.println("type = " + triangle.getType());

        System.out.println("--------------------------work with a complex-------------------------------------------");
        MyComplex pin = new MyComplex(1, 1);
        MyComplex pin1 = new MyComplex(2,2);
        System.out.println(pin + " + " + pin1 + " = " + pin.addNew(pin1));
        System.out.println(pin + " - " + pin1 + " = " + pin.substractNew(pin1));
        System.out.println(pin + " * " + pin1 + " = " + pin.multiply(pin1));
        System.out.println(pin + " / " + pin1 + " = " + pin.divide(pin1));
        System.out.println("Argument " + pin + " = " + pin.argument());
        System.out.println("Magnitude " + pin1 + " = " + pin1.magnitude());

        System.out.println("--------------------------work with a polynomial----------------------------------------");
        MyPolynomial poly = new MyPolynomial(3,1,2);
        MyPolynomial poly1 = new MyPolynomial(8,2,6,5);
        System.out.println(poly + " for x = 2 -> " + poly.evaluate(2));
        System.out.println("(" + poly + ")" + " + " + "(" + poly1 + ")" + " = " + poly.add(poly1));
        System.out.println("(" + poly + ")" + " * " + "(" + poly1 + ")" + " = " + poly.multiply(poly1));

        System.out.println("--------------------------work with a ball----------------------------------------------");
        Ball ball = new Ball(3,3,1,2,90);
        Container con = new Container(0,0, 4,8);
        System.out.println("Container = " + con);
        System.out.println("Ball coords = " + ball);
        System.out.println("ball in container? -> " + con.collides(ball));
        ball.move();
        System.out.println("Ball coords = " + ball);
        System.out.println("ball in container? -> " + con.collides(ball));
        ball.move();
        System.out.println("Ball coords = " + ball);
        System.out.println("ball in container? -> " + con.collides(ball));
        ball.move();
        System.out.println("Ball coords = " + ball);
        System.out.println("ball in container? -> " + con.collides(ball));
        ball.move();
        System.out.println("Ball coords = " + ball);
        System.out.println("ball in container? -> " + con.collides(ball));
    }
}