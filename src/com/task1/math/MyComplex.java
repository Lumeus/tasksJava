package com.task1.math;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        String str = "(" + real;
        if (imag < 0) {
            str += imag + ')';
        } else {
            str += '-' + imag + ')';
        }
        return str;
    }

    public boolean isReal() {
        return imag == 0.0;
    }

    public boolean isImaginary() {
        return real == 0.0;
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex another) {
        return equals(another.real, another.imag);
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        return Math.atan(imag/real);
    }

    public MyComplex add(MyComplex right) {
        real += right.real;
        imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(real + right.real, imag + right.imag);
    }

    public MyComplex substract(MyComplex right) {
        real -= right.real;
        imag -= right.imag;
        return this;
    }
    public MyComplex substractNew(MyComplex right) {
        return new MyComplex(real - right.real, imag - right.imag);
    }
    public MyComplex multiply(MyComplex right) {
        real = real * right.real - imag * right.imag;
        imag = real * right.imag + imag * right.real;
        return this;
    }
    public MyComplex divide(MyComplex right) {
        real = (real * right.real + imag * right.imag) / right.magnitude();
        imag = (imag * right.real - real * right.imag) / right.magnitude();
        return this;
    }
    public MyComplex conjugate() {
        imag = -imag;
        return this;
    }
}
