package edu.design_patterns.decorator;

public class CaramelDecorator extends AddOnDecorator {

    private static final double CARAMEL_COST = 2.0;

    public CaramelDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + CARAMEL_COST;
    }
}
