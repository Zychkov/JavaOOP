package ru.zychkov.temperatureconverter.gui;

import ru.zychkov.temperatureconverter.convert.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class TemperatureGUI {
    private final static HashMap<Integer, TemperatureConverter> convertMap;

    static {
        convertMap = new HashMap<>();
        convertMap.put(0, new ConvertToFahrenheit());
        convertMap.put(1, new ConvertToCelsius());
        convertMap.put(2, new ConvertToKelvin());
    }

    private static final String fahrenheit = "º F";
    private static final String celsius = "º C";
    private static final String kelvin = "  K";

    private JFormattedTextField entryField = new JFormattedTextField();
    private JFormattedTextField outField = new JFormattedTextField();

    private String[] elements = new String[]{fahrenheit, celsius, kelvin};
    private JComboBox<String> comboBoxIn = new JComboBox<>(elements);
    private JComboBox<String> comboBoxOut = new JComboBox<>(elements);


    public TemperatureGUI() {
        JFrame frame = new JFrame("Конвертер температур");
        frame.setSize(450, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel upPanel = new JPanel();
        frame.add(upPanel, BorderLayout.PAGE_START);

        JLabel labelTemperatureIn = new JLabel("Выбери исходную температуру");
        upPanel.add(labelTemperatureIn);

        upPanel.add(comboBoxIn);

        entryField.setColumns(15);
        upPanel.add(entryField);

        JPanel midPanel = new JPanel();
        frame.add(midPanel, BorderLayout.CENTER);

        JButton convertButton = new JButton("Перевести");
        midPanel.add(convertButton);

        JPanel downPanel = new JPanel();
        frame.add(downPanel, BorderLayout.PAGE_END);

        JLabel labelTemperatureOut = new JLabel("Выбери конечную температуру");
        downPanel.add(labelTemperatureOut);

        downPanel.add(comboBoxOut);

        outField.setColumns(15);
        outField.setEditable(false);
        outField.setForeground(Color.red);
        downPanel.add(outField);

        convertButton.addActionListener(e -> {
            if (isNumber()) {
                convertTemperature();
            } else {
                JOptionPane.showMessageDialog(convertButton, "Ошибка. Введите число! Или разделитель - точку!", "Error", JOptionPane.WARNING_MESSAGE);
                entryField.setText(null);
                outField.setText(null);
            }
        });
    }

    private void convertTemperature() {
        String entryString = entryField.getText();
        if (comboBoxIn.getSelectedIndex() == comboBoxOut.getSelectedIndex()) {
            outField.setText(String.valueOf(entryString));
        }

        double anyTemperatureToCelsius = convertMap.get(comboBoxIn.getSelectedIndex()).temperatureToCelsius(Double.valueOf(entryString));
        double fromCelsiusToTargetTemperature = convertMap.get(comboBoxOut.getSelectedIndex()).temperatureFromCelsius(anyTemperatureToCelsius);
        outField.setText(String.valueOf(fromCelsiusToTargetTemperature));
    }

    private boolean isNumber() {
        String entryString = entryField.getText();
        try {
            Double.parseDouble(entryString);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }
}
