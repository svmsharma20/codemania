package edu.design_patterns.abstract_factory;

public class LightTextField implements TypableUIComponent {

    @Override
    public void type() {
        System.out.println("Textfield [Text color: Black, Background color: White]");
    }
}
