package edu.design_patterns.adapter;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public String description() {
        return "Circle object";
    }
}
