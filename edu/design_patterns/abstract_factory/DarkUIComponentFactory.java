package edu.design_patterns.abstract_factory;

public class DarkUIComponentFactory implements UIComponentFactory {

    @Override
    public ClickableUIComponent getClickable() {
        return new DarkButton();
    }

    @Override
    public TypableUIComponent getTypable() {
        return new DarkTextfield();
    }
}
