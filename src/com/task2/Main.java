package com.task2;

import com.task2.ch2.MyPoint;
import com.task2.ch2.MyPointMutator;
import com.task2.ch3.Employee;
import com.task2.ch3.Measurable;
import com.task2.ch4.Circle;
import com.task2.ch4.Line;
import com.task2.ch4.Rectangle;
import com.task2.ch4.Shape;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("\n===== Chapter 1 =====");
        System.out.println("\n---- Exercise 01 ----\n");
        com.task2.ch1.Ex1.doIt();

        System.out.println("\n---- Exercise 02 ----\n");
        com.task2.ch1.Ex2.doIt();

        System.out.println("\n---- Exercise 03 ----\n");
        com.task2.ch1.Ex3.doIt();

        System.out.println("\n---- Exercise 04 ----\n");
        com.task2.ch1.Ex4.doIt();

        System.out.println("\n---- Exercise 06 ----\n");
        com.task2.ch1.Ex6.doIt();

        System.out.println("\n---- Exercise 13 ----\n");
        com.task2.ch1.Ex13.doIt();


        System.out.println("\n===== Chapter 2 =====");
        System.out.println("\n---- Exercise 05 ----\n");
        MyPoint p = new MyPoint(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p);

        System.out.println("\n---- Exercise 09 ----\n");
        MyPointMutator pM = new MyPointMutator(3, 4);
        pM.translate(12, 6.7);
        pM.scale(0.8);
        System.out.println(pM);


        System.out.println("\n===== Chapter 3 =====");
        System.out.println("\n---- Exercise 01 ----\n");
        Measurable[] employees = {
                new Employee(1, "peter", "ivanov", 1000),
                new Employee(2, "dima", "petrov", 3000),
                new Employee(3, "zhenya", "semenov", 2500)
        };
        System.out.println("average salary = " + Measurable.average(employees));

        System.out.println("\n---- Exercise 02 ----\n");
        System.out.println("largest salary = " + ((Employee)Measurable.largest(employees)).getName());


        System.out.println("\n===== Chapter 4 =====");
        System.out.println("\n---- Exercise 04 ----\n");
        Shape figure = new Circle(new MyPoint(1.0,1.0), 2.5);
        figure.moveBy(5,6.5);
        System.out.println("center Circle = " + figure.getCenter());

        figure = new Rectangle(new MyPoint(0,7), 4, 5);
        figure.moveBy(2, -6.5);
        System.out.println("center Rectangle = " + figure.getCenter());

        figure = new Line(new MyPoint(1, 1), new MyPoint(3, 3));
        figure.moveBy(5, 1);
        System.out.println("center Line = " + figure.getCenter());

        System.out.println("\n---- Exercise 05 ----\n");
        Circle c1 = new Circle(new MyPoint(1,1), 3);
        Circle c2 = c1.clone();
        c1.moveBy(2,2);
        System.out.println(c1 + "\n" + c2);

        Rectangle r1 = new Rectangle(new MyPoint(1, 1),1 ,1);
        Rectangle r2 = r1.clone();
        r1.moveBy(2,2);
        System.out.println(r1 + "\n" + r2);

        Line l1 = new Line(new MyPoint(1,1), new MyPoint(2, 2));
        Line l2 = l1.clone();
        l1.moveBy(2,2);
        System.out.println(l1 + "\n" + l2);
    }
}
