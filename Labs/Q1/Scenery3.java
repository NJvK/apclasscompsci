package Labs.Q1;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
public class Scenery3 extends JPanel{
    int choice;

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500,500);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSky(g);
        drawCloudySky(g);
        drawWall(g,0,200);
        drawPeople(g,400,400);
        drawPeople(g,300,400);
        drawPeople(g,250,400);
        drawPeople(g,100,400);
        drawPeople(g, 425, 325);
        drawPeople(g, 325, 325);
        drawPeople(g, 275, 325);
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
        g.setColor(Color.CYAN);
        g.fillRect(0,0,500,500);
    }
    private void drawMoon(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(380,0,100,100);
        g.drawOval(380,0,100,100);
    }
    private void drawGround(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0,200,500,300);
    }
    // private void drawClearSky(Graphics g){
    //     drawSun(g);
    //     drawGround(g);
    // }
    private void drawCloud(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,50,50);
        g.fillOval(x+25,y-25,50,50);
        g.fillOval(x+50,y,50,50);
        g.fillOval(x+25,y+10,50,50);
    }
    // private void drawRain(Graphics g, int x, int y){
    //     g.setColor(Color.BLUE);
    //     g.drawLine(x,y,x-10,y+25);
    //     g.drawLine(x+10,y,x,y+25);
    //     g.drawLine(x+20,y,x+10,y+25);
    //     g.drawLine(x+30,y,x+20,y+25);
    //     g.drawLine(x+40,y,x+30,y+25);
    // }
    // private void drawRainCloud(Graphics g, int x, int y){
    //     drawCloud(g,x,y);
    //     for(int i=0; i<5; i++){
    //         drawRain(g,x+10*i+10,y+25);
    //     }
    //     drawGround(g);
    // }
    private void drawCloudySky(Graphics g){
        drawCloud(g,50,50);
        drawCloud(g,200,100);
        drawCloud(g,350,50);
        drawGround(g);
        drawMoon(g);
    }
    // private void drawRainySky(Graphics g){
    //     drawRainCloud(g,50,50);
    //     drawRainCloud(g,200,100);
    //     drawRainCloud(g,350,50);
    //     drawGround(g);
    // }
}