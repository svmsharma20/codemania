package edu.design_patterns.decorator;

public class MochaDecorator extends AddOnDecorator {

    private static final double MOCHA_PRICE = 5.0;

    public MochaDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + MOCHA_PRICE;
    }
}
