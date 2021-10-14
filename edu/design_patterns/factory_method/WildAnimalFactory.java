package edu.design_patterns.factory_method;

public class WildAnimalFactory implements AnimalFactory {

    @Override
    public Animal getAnimal(String type) {
        if (type.equalsIgnoreCase("big")) {
            return new Elephant();
        }

        return new Lion();
    }
}
