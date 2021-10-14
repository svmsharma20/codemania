package edu.design_patterns.abstract_factory;

public class LightUIComponentFactory implements UIComponentFactory {

    @Override
    public ClickableUIComponent getClickable() {
        return new LightButton();
    }

    @Override
    public TypableUIComponent getTypable() {
        return new LightTextField();
    }
}
