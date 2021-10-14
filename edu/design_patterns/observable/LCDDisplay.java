package edu.design_patterns.observable;

public class LCDDisplay implements IObserver {

    private static final String NAME = "LCD_DISPLAY";
    private WeatherStation weatherStation;

    public LCDDisplay(WeatherStation weatherStation) {
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
