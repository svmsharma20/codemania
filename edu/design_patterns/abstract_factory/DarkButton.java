package edu.design_patterns.abstract_factory;

public class DarkButton implements ClickableUIComponent {

    @Override
    public void click() {
        System.out.println("Button [Text color: White, Background color: Black]");
    }
}
