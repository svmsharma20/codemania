package edu.design_patterns.decorator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Coffee: " + getCoffee().cost());
        System.out.println("Skimmed Milk Coffee: " + getSkimmedMilkMixed(getCoffee()).cost());
        System.out.println("Skimmed Milk Caramel Coffee : " +
            getSkimmedMilkMixed(getCaramelMixed(getCoffee())).cost());
        System.out.println("Skimmed Milk Ginger Tea : " + getSkimmedMilkMixed(getTea()).cost());
        System.out.println("Skimmed Milk Mocha Espresso : " +
            getSkimmedMilkMixed(getMochaMIxed(getEspresso())).cost());
    }

    private static Beverage getMochaMIxed(Beverage beverage) {
        return new MochaDecorator(beverage);
    }

    private static Beverage getSkimmedMilkMixed(Beverage beverage) {
        return new SkimmedMilkDecorator(beverage);
    }

    private static Beverage getCaramelMixed(Beverage beverage) {
        return new CaramelDecorator(beverage);
    }

    private static Beverage getCoffee() {
        return new Coffee();
    }

    private static Beverage getEspresso() {
        return new Espresso();
    }

    private static Beverage getTea() {
        return new Tea();
    }
}
