package Q1;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
public class Scenery2 extends JPanel{
    int choice;

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500,500);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSky(g);
        drawMoon(g);
        drawWall(g,0,200);
        drawPeople(g,400,400);
        drawPeople(g,350,400);
        drawPeople(g,300,400);
        drawPeople(g,250,400);
        drawPeople(g,200,400);
        drawPeople(g,150,400);
        drawPeople(g,100,400);
        drawPeople(g,50,400);
    }
    // See if this code is useful later
    // private void drawBuilding(Graphics g, int x, int y){
    //     g.setColor(Color.BLACK);
    //     g.drawRect(x,y,100,75);
    //     g.fillRect(x,y,100,75);
    //     g.setColor(Color.DARK_GRAY);
    //     int[] xPoints = {x-25,x+50,x+125};
    //     int[] yPoints = {y,y-50,y};
    //     g.drawPolygon(xPoints,yPoints,3);
    //     g.fillPolygon(xPoints,yPoints,3);
    //     g.setColor(Color.DARK_GRAY);
    //     g.drawRect(x+25,y+25,25,25);
    //     g.fillRect(x+25,y+25,25,25);
    // }
    // ------------Wall---------------------------
    private void drawWall(Graphics g, int x, int y){
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x,y,500,200);
        g.fillRect(x,y,500,200);
        g.setColor(Color.DARK_GRAY);
        int[] xPoints = {x-25,x+50,x+125};
        int[] yPoints = {y,y-50,y};
        g.drawPolygon(xPoints,yPoints,3);
        g.fillPolygon(xPoints,yPoints,3);
        // g.setColor(Color.YELLOW);
        // g.drawRect(x+25,y+25,25,25);
        // g.fillRect(x+25,y+25,25,25);
    }
    // ------------People-------------------------
    private void drawPeople(Graphics g, int x, int y){
        g.setColor(Color.PINK);
        g.drawOval(x,y,25,25);
        g.fillOval(x,y,25,25);
        g.setColor(Color.BLUE);
        g.drawRect(x+5,y+25,15,30);
        g.fillRect(x+5,y+25,15,30);
        g.setColor(Color.BLACK);
        g.drawLine(x+5,y+55,x,y+75);
        g.drawLine(x+20,y+55,x+25,y+75);
        g.drawLine(x+5,y+35,x-10,y+25);
        g.drawLine(x+20,y+35,x+35,y+25);
    }
    // ------------Sky & Sun----------------------
    private void drawSky(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,500,500);
    }
    private void drawMoon(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(380,0,100,100);
        g.drawOval(380,0,100,100);
    }
}