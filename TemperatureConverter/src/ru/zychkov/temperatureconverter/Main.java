package ru.zychkov.temperatureconverter;

import ru.zychkov.temperatureconverter.gui.TemperatureGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperatureGUI::new);
    }
}
