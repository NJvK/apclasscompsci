package IfYourBored;

import javax.swing.*;

public class CalculaterRunner {
    public static void main(String[] args) throws Exception {
        // Use a LAF that respects button background colors
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtilities.invokeLater(Calculater::new);
    }
}
