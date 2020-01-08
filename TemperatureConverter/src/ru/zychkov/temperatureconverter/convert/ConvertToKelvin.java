package ru.zychkov.temperatureconverter.convert;

public class ConvertToKelvin implements TemperatureConverter {
    @Override
    public double temperatureToCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double temperatureFromCelsius(double temperature) {
        return temperature + 273.15;
    }
}

