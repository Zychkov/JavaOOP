package ru.zychkov.temperatureconverter.convert;

public class ConvertToFahrenheit implements TemperatureConverter {
    @Override
    public double temperatureToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    @Override
    public double temperatureFromCelsius(double temperature) {
        return (temperature * 9 / 5) + 32;
    }
}
