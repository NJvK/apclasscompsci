package Labs.Q1;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
public class Scenery extends JPanel{
    int choice;

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500,500);
    }
    @Override
    public void paintComponent(Graphics g){
        Color brownColor = new Color(139,69,19);
        super.paintComponent(g);
        //------------Sky-----------------------------
        g.setColor(Color.CYAN);
        g.fillRect(0,0,500,500);
        //------------Sun-----------------------------
        g.setColor(Color.YELLOW);
        g.fillOval(380,0,100,100);
        g.drawOval(380,0,100,100);
        //------------Grass---------------------------
        g.setColor(Color.GREEN);
        g.drawRect(0,300,500,200);
        g.fillRect(0,300,500,200);
        //------------Tree----------------------------
        g.setColor(brownColor);
        g.drawRect(75,200,50,100);
        g.fillRect(75,200,50,100);
        g.setColor(Color.GREEN);
        g.drawOval(65,150,100,100);
        g.fillOval(65,150,100,100);
        //------------House---------------------------
        g.setColor(Color.RED);
        g.drawRect(325,225,100,75);
        g.fillRect(325,225,100,75);
        g.setColor(Color.DARK_GRAY);
        int[] xPoints = {300,375,450};
        int[] yPoints = {225,175,225};
        g.drawPolygon(xPoints,yPoints,3);
        g.fillPolygon(xPoints,yPoints,3);
        g.setColor(Color.YELLOW);
        g.drawRect(350,250,25,25);
        g.fillRect(350,250,25,25);
        //------------Lake---------------------------
        g.setColor(Color.BLUE);
        g.drawOval(50,320,100,50);
        g.fillOval(50,320,100,50);
    }
    // @Override
    // public void paintComponent(Graphics g){

    // }
}