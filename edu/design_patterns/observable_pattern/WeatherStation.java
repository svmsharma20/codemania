package edu.design_patterns.observable_pattern;

import java.util.ArrayList;

public class WeatherStation implements IObserverable {

    private double temperature;
    private ArrayList<IObserver> observerList;

    public WeatherStation() {
        this.temperature = 32.47;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(IObserver observer) {
        observerList.add(observer);
        System.out.println(observer.getName() + " registered....");
    }

    @Override
    public void unregister(IObserver observer) {
        observerList.remove(observer);
        System.out.println(observer.getName() + " unregistered....");
    }

    @Override
    public void notifyObserver() {
        for (IObserver observer : observerList) {
            observer.update();
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObserver();
    }
}
