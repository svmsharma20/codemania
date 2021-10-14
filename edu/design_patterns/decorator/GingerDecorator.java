package edu.design_patterns.decorator;

public class GingerDecorator extends AddOnDecorator {

    private static final double GINGER_PRICE = 3.0;

    public GingerDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + GINGER_PRICE;
    }
}
