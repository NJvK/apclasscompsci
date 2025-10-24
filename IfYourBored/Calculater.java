package IfYourBored;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculater {
    int boardWith = 360;
    int boardHeight = 540;

    Color lightGrey = new Color(212, 212, 210);
    Color darkGrey = new Color(80, 80, 80);
    Color black = new Color(28, 28, 28);
    Color Orange = new Color(255, 149, 0);

    String[] buttonValues = {
        "AC", "+/-", "%", "÷",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "x", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("Calculater");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    double accumulator = 0.0;
    String pendingOp = null;
    boolean startNewNumber = true;

    public Calculater() {
        frame.setSize(boardWith, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(black);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 64));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        JButton button = new JButton(label);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(yourColor);
        button.setForeground(yourTextColor);


        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel, BorderLayout.CENTER);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(black);
        frame.add(buttonsPanel, BorderLayout.CENTER);

        for (String buttonValue : buttonValues) {
            JButton button = new JButton(buttonValue);
            button.setFont(new Font("Arial", Font.PLAIN, 28));
            button.setFocusable(false);
            button.setBorder(new LineBorder(black));

            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(lightGrey);
                button.setForeground(black);
            } else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(Orange);
                button.setForeground(black);
            } else {
                button.setBackground(darkGrey);
                button.setForeground(Color.white);
            }

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String v = ((JButton) e.getSource()).getText();

                    if (Arrays.asList(rightSymbols).contains(v)) {
                        if (v.equals("=")) {
                            applyPending();
                            pendingOp = null;
                            startNewNumber = true;
                        } else {
                            if (!startNewNumber) {
                                applyPending();
                            } else {
                                accumulator = parseDisplay();
                            }
                            pendingOp = v;
                            startNewNumber = true;
                        }

                    } else if (Arrays.asList(topSymbols).contains(v)) {
                        handleTop(v);
                    } else {
                        handleNumberInput(v);
                    }
                }
            });

            buttonsPanel.add(button);
        }

        frame.setVisible(true);
    }

    private void handleTop(String v) {
        if (v.equals("AC")) {
            accumulator = 0.0;
            pendingOp = null;
            startNewNumber = true;
            displayLabel.setText("0");
        } else if (v.equals("+/-")) {
            if (!displayLabel.getText().equals("0") && !displayLabel.getText().equals("Error")) {
                double val = -parseDisplay();
                showNumber(val);
                if (startNewNumber) accumulator = val;
            }
        } else if (v.equals("%")) {
            double val = parseDisplay() / 100.0;
            showNumber(val);
            startNewNumber = true;
        }
    }

    private void handleNumberInput(String v) {
        if (v.equals(".")) {
            if (startNewNumber || displayLabel.getText().equals("Error")) {
                displayLabel.setText("0.");
                startNewNumber = false;
            } else if (!displayLabel.getText().contains(".")) {
                displayLabel.setText(displayLabel.getText() + ".");
            }
            return;
        }

        if ("0123456789".contains(v)) {
            if (startNewNumber || displayLabel.getText().equals("0") || displayLabel.getText().equals("Error")) {
                displayLabel.setText(v);
                startNewNumber = false;
            } else {
                displayLabel.setText(displayLabel.getText() + v);
            }
            return;
        }

        if (v.equals("√")) {
            double current = parseDisplay();
            if (current < 0) {
                showError();
            } else {
                showNumber(Math.sqrt(current));
                startNewNumber = true;
            }
        }
    }

    private void applyPending() {
        double current = parseDisplay();
        if (pendingOp == null) {
            accumulator = current;
            showNumber(accumulator);
            return;
        }

        switch (pendingOp) {
            case "+":
                accumulator += current;
                break;
            case "-":
                accumulator -= current;
                break;
            case "x":
                accumulator *= current;
                break;
            case "÷":
                if (current == 0.0) {
                    showError();
                    return;
                }
                accumulator /= current;
                break;
        }
        showNumber(accumulator);
    }

    private double parseDisplay() {
        try {
            return Double.parseDouble(displayLabel.getText());
        } catch (NumberFormatException ex) {
            return 0.0;
        }
    }

    private void showNumber(double x) {
        String s = Double.toString(x);
        if (s.endsWith(".0")) s = s.substring(0, s.length() - 2);
        displayLabel.setText(s);
    }

    private void showError() {
        displayLabel.setText("Error");
        accumulator = 0.0;
        pendingOp = null;
        startNewNumber = true;
    }
}
