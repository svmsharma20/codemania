package edu.design_patterns.abstract_factory;

public class Main {

    public static void main(String[] args) {
        // 1. Theme is Light
        System.out.println("-------Light Theme-------");
        UIComponentFactory lightUIComponentFactory = new LightUIComponentFactory();
        lightUIComponentFactory.getClickable().click();
        lightUIComponentFactory.getTypable().type();

        // 2. Theme is Dark
        System.out.println("-------Dark Theme-------");
        UIComponentFactory darkUIComponentFactory = new DarkUIComponentFactory();
        darkUIComponentFactory.getClickable().click();
        darkUIComponentFactory.getTypable().type();
    }
}
