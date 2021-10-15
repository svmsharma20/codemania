package edu.design_patterns.adapter;

public class GeometricShapeObjectAdapter implements Shape {

    private GeometricShape adaptee;

    public GeometricShapeObjectAdapter(GeometricShape adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void draw() {
        adaptee.drawShape();
    }

    @Override
    public String description() {
        if (adaptee instanceof Traingle) {
            return "Triangle object";
        }

        return "Unknown object";
    }
}
