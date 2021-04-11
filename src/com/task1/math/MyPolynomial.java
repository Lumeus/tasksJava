package com.task1.math;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double ... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String str = "";
        int i = 0;
        for (double c: coeffs) {
            switch (i) {
                case 0: str = c + str; break;
                case 1: str = c + "x + " + str; break;
                default: str = c + "x^" + i + " + " + str;
            }
            i++;
        }
        return str;
    }

    public double evaluate(double x) {
        double res = 0;
        int i = 0;
        for (double c: coeffs) {
            res += c * Math.pow(x, i);
            i++;
        }
        return res;
    }

    public MyPolynomial add(MyPolynomial right) {
        MyPolynomial res;
        double[] coeffs;
        if (this.coeffs.length > right.coeffs.length) {
            res = new MyPolynomial(this.coeffs);
            coeffs = right.coeffs;
        } else {
            res = new MyPolynomial(right.coeffs);
            coeffs = this.coeffs;
        }
        for (int i = 0; i < coeffs.length; i++){
            res.coeffs[i] += coeffs[i];
        }
        return res;
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int degreeOfThis = this.coeffs.length;
        int degreeOfRight = right.coeffs.length;
        double[] newCoeffs = new double[degreeOfThis + degreeOfRight - 1];
        for (int i = 0; i < degreeOfThis; i++ ) {
            for (int j = 0; j < degreeOfRight; j++) {
                newCoeffs[i+j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }
}
