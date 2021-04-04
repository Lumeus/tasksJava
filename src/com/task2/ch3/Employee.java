package com.task2.ch3;

public class Employee implements Measurable {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return firstName + ' ' + lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        salary += (percent * salary)/100;
        return salary;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "id=" + id +
                ", name=" + firstName + ' ' + lastName + '\'' +
                ", salary=" + salary +
                ']';
    }

    @Override
    public double getMeasure() {
        return salary;
    }
}
