package edu.design_patterns.decorator;

public abstract class AddOnDecorator implements Beverage {

    private Beverage beverage;

    public AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return this.beverage.cost();
    }
}
