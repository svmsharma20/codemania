package edu.design_patterns.factory_method;

public class Main {

    // https://refactoring.guru/design-patterns/factory-method
    public static void main(String[] args) {
        AnimalFactory domesticAnimalFactory = new DomesticAnimalFactory();
        AnimalFactory wildAnimalFactory = new WildAnimalFactory();

        domesticAnimalFactory.getAnimal("big").speak();
        domesticAnimalFactory.getAnimal("small").speak();
        domesticAnimalFactory.getAnimal("energetic").speak();

        wildAnimalFactory.getAnimal("big").speak();
        wildAnimalFactory.getAnimal("strong").speak();
    }
}
