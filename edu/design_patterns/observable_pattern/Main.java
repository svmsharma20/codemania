package edu.design_patterns.observable_pattern;

public class Main {

    // https://www.youtube.com/watch?v=_BpmfnqjgzQ&list=PLrhzvIcii6GNjpARdnO4ueTUAVR9eMBpc&index=2
    public static void main(String[] args) {
        // 1. Create a Observable
        WeatherStation weatherStation = new WeatherStation();

        // 2. Create some Observers
        LCDDisplay lcdDisplay = new LCDDisplay(weatherStation);
        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);

        // 3. Register observers with Observable
        weatherStation.register(lcdDisplay);
        weatherStation.register(phoneDisplay);

        // 4. Update the data in Observable
        weatherStation.setTemperature(40.00);

        // 5. Unregister one observer
        weatherStation.unregister(phoneDisplay);

        // 6. Update the data in Observable
        weatherStation.setTemperature(37.55);
    }
}
