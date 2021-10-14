package edu.design_patterns.decorator;

public class SkimmedMilkDecorator extends AddOnDecorator {

    private static final double SKIMMED_MILK_PRICE = 8.0;

    public SkimmedMilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + SKIMMED_MILK_PRICE;
    }
}
