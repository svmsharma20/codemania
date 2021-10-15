package edu.design_patterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class Drawing {

    List<Shape> shapes = new ArrayList<>();

    public Drawing() {
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void draw() {
        if (shapes.isEmpty()) {
            System.out.println("Nothing to draw");
        } else {
            for (Shape shape : shapes) {
                shape.draw();
            }
        }
    }
}
