import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class temperatureConverter {


    public class TemperatureConverter extends JFrame {
        private JTextField inputField;
        private JLabel resultLabel;

        public TemperatureConverter() {
            setTitle("Temperature Converter");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 150);
            setLocationRelativeTo(null);

            // Create components
            JRadioButton fahrenheitToCelsiusButton = new JRadioButton("Fahrenheit to Celsius");
            JRadioButton celsiusToFahrenheitButton = new JRadioButton("Celsius to Fahrenheit");
            inputField = new JTextField(10);
            JButton convertButton = new JButton("Convert");
            resultLabel = new JLabel("Converted temperature: ");

            // Add components to the content pane
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1));
            panel.add(fahrenheitToCelsiusButton);
            panel.add(celsiusToFahrenheitButton);
            panel.add(inputField);
            panel.add(convertButton);
            panel.add(resultLabel);

            ButtonGroup conversionGroup = new ButtonGroup();
            conversionGroup.add(fahrenheitToCelsiusButton);
            conversionGroup.add(celsiusToFahrenheitButton);

            add(panel);

            // Add action listener for the "Convert" button
            convertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double inputValue = Double.parseDouble(inputField.getText());
                        double convertedValue;
                        String conversionType;

                        if (fahrenheitToCelsiusButton.isSelected()) {
                            convertedValue = (inputValue - 32) * 5.0 / 9.0;
                            conversionType = "Celsius";
                        } else {
                            convertedValue = inputValue * 9.0 / 5.0 + 32;
                            conversionType = "Fahrenheit";
                        }

                        resultLabel.setText("Converted temperature: " + convertedValue + " " + conversionType);
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input");
                    }
                }
            });
        }
    }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                temperatureConverter converter = new temperatureConverter();
                converter.setVisible(true);
            });
        }

    public void setVisible(boolean b) {
        b=true;
    }
}


