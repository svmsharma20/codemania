package edu.design_patterns.adapter;

public class Main {

    /*
     * https://dzone.com/articles/adapter-design-pattern-in-java
     * https://www.youtube.com/watch?v=2PKQtcJjYvc&list=PLrhzvIcii6GNjpARdnO4ueTUAVR9eMBpc&index=8
     * */
    public static void main(String[] args) {
        System.out.println("Creating drawing of shapes...");
        Drawing drawing = new Drawing();
        drawing.addShape(new Rectangle());
        drawing.addShape(new Circle());

        // Adding geometric shapes to drawing
        drawing.addShape(new GeometricShapeObjectAdapter(new Traingle()));
        System.out.println("Drawing...");
        drawing.draw();
    }
}
