package edu.design_patterns.adapter;

public class Traingle implements GeometricShape {

    private final double a;
    private final double b;
    private final double c;

    public Traingle() {
        this(1.0d, 1.0d, 1.0d);
    }

    public Traingle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public void drawShape() {
        System.out.println("Drawing Triangle with area: " + area());
    }
}
