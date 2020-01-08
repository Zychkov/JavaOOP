package ru.zychkov.temperatureconverter.convert;

public class ConvertToCelsius implements TemperatureConverter {
    @Override
    public double temperatureToCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double temperatureFromCelsius(double temperature) {
        return temperature;
    }
}
