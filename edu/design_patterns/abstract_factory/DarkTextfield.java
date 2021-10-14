package edu.design_patterns.abstract_factory;

public class DarkTextfield implements TypableUIComponent {

    @Override
    public void type() {
        System.out.println("Textfield [Text color: White, Background color: Black]");
    }
}
