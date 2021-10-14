package edu.design_patterns.observable;

public class PhoneDisplay implements IObserver {

    private static final String NAME = "PHONE_DISPLAY";
    private WeatherStation weatherStation;

    public PhoneDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println(
            "Update by " + NAME + " -> Temperature : " + weatherStation.getTemperature());
    }

    @Override
    public String getName() {
        return NAME;
    }
}
