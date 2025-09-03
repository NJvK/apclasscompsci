package IfYourBored;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder; // modifying the border of the butons for the calculater
public class Calculater {
    int boardWith = 360; // sets the board with to 360 pixles
    int boardHeight = 540; // sets the board height to 540 pixles

    Color lightGrey = new Color(212, 212, 210); // sets up colors used for calculater
    Color darkGrey = new Color(80, 80, 80);
    Color black = new Color(28, 28, 28);
    Color Orange = new Color(255, 149, 0);

    String[] buttonValues = { // string is just a list of diffrent buttons
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "x", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "x", "-", "+", "="}; // sets spisific buttons right
    String[] topSymbols = {"AC", "+/-", "%"}; // sets spisific buttons top

    JFrame frame = new JFrame("Calculater");// the text you will see at the thop of the window
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    Calculater() {
        frame.setVisible(true);
        frame.setSize(boardWith, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false); // makes it so that the user cant drag and resize the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when user cliks x on the window the program will be terminated
        frame.setLayout(new BorderLayout()); // can place border components north south east or west within window
        
        displayLabel.setBackground(black);
        displayLabel.setForeground(Color.white); // sets text to standerd white
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80)); // sets font sixe and type
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);// sets text to the right
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(black);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttonValues.length; i++){ // sets the buttons to be diffrent colors
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(black));
            if (Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(lightGrey);
                button.setForeground(black);
            } else if (Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(Orange);
                button.setForeground(black);
            } else {
                button.setBackground(darkGrey);
                button.setForeground(Color.white);
            }

            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPreformed(ActionEvent e){
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();
                }
            })
        }
    }
}
