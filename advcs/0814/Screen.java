import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Screen extends JPanel {
    private int result;

    public Screen() {
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.WHITE);
        result = 0;
    }

    public void setResult(int result) {
        this.result = result;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Result: " + result, 20, 20);
    }
    public int getResult() {
        return result;
    }
    public void display() {
        System.out.println("Displaying the screen with result: " + result);
    }
    String [] keys = {
        "C" , "+/-" , "%" , "/" ,
        "7" , "8" , "9" , "*" ,
        "4" , "5" , "6" , "-" ,
        "3" , "2" , "1" , "+" ,
        " " , "0" , "." , "="
    };
}

