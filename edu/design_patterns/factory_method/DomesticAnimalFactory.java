package edu.design_patterns.factory_method;

public class DomesticAnimalFactory implements AnimalFactory {

    @Override
    public Animal getAnimal(String type) {
        if (type.equalsIgnoreCase("big")) {
            return new Cow();
        } else if (type.equalsIgnoreCase("small")) {
            return new Cat();
        }

        return new Dog();
    }
}
