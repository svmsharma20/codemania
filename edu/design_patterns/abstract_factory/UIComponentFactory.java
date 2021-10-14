package edu.design_patterns.abstract_factory;

public interface UIComponentFactory {

    ClickableUIComponent getClickable();

    TypableUIComponent getTypable();
}
