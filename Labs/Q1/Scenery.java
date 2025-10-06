package Q1;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.util.Scanner;
public class Scenery extends JPanel{
    private int choice;
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500,500);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        System.out.println("pick your time of day: 1 for day, 2 for night");
        choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("pick your scenery: 1. Clear Sky 2. Cloudy Sky 3. Rainy Sky");
            choice = scanner.nextInt();
            if (choice == 1) {
                drawSky(g);
                drawClearSky(g);
                drawWall(g,0,200);
                drawPeople(g,400,400);
                drawPeople(g,350,400);
                drawPeople(g,300,400);
                drawPeople(g,250,400);
                drawPeople(g,200,400);
                drawPeople(g,150,400);
                drawPeople(g,100,400);
                drawPeople(g,50,400);
                drawPeople(g, 425, 325);
                drawPeople(g, 375, 325);
                drawPeople(g, 325, 325);
                drawPeople(g, 275, 325);
                drawPeople(g, 225, 325);
                drawPeople(g, 175, 325);
                drawPeople(g, 125, 325);
                drawBuilding(g, 100, 100);
            } else if (choice == 2){
                drawSky(g);
                drawCloudySky(g);
                drawWall(g,0,200);
                drawPeople(g,400,400);
                drawPeople(g,350,400);
                drawPeople(g,300,400);
                drawPeople(g,250,400);
                drawPeople(g,200,400);
                drawPeople(g,150,400);
                drawPeople(g,100,400);
                drawPeople(g,50,400);
                drawPeople(g, 425, 325);
                drawPeople(g, 375, 325);
                drawPeople(g, 325, 325);
                drawPeople(g, 275, 325);
                drawPeople(g, 225, 325);
                drawPeople(g, 175, 325);
                drawPeople(g, 125, 325);
            } else if (choice == 3){
                drawSky(g);
                drawRainySky(g);
                drawWall(g,0,200);
                drawPeople(g,400,400);
                drawPeople(g,350,400);
                drawPeople(g,300,400);
                drawPeople(g,250,400);
                drawPeople(g,200,400);
                drawPeople(g,150,400);
                drawPeople(g,100,400);
                drawPeople(g,50,400);
                drawPeople(g, 425, 325);
                drawPeople(g, 375, 325);
                drawPeople(g, 325, 325);
                drawPeople(g, 275, 325);
                drawPeople(g, 225, 325);
                drawPeople(g, 175, 325);
                drawPeople(g, 125, 325);
            }
        } else if (choice == 2) {
            System.out.println("pick your choice of weather at night, 1 for clear, 2 for cloudy, 3 for rainy");
            choice = scanner.nextInt();
            if (choice == 1) {
                drawNightSky(g);
                drawClearNightSky(g);
                drawWall(g,0,200);
                drawPeople(g,400,400);
                drawPeople(g,300,400);
                drawPeople(g,250,400);
                drawPeople(g,100,400);
                drawPeople(g, 425, 325);
                drawPeople(g, 325, 325);
                drawPeople(g, 275, 325);
            } else if (choice == 2){
                drawNightSky(g);
                drawCloudySky(g);
                drawWall(g,0,200);
                drawPeople(g,400,400);
                drawPeople(g,300,400);
                drawPeople(g,250,400);
                drawPeople(g,100,400);
                drawPeople(g, 425, 325);
                drawPeople(g, 325, 325);
                drawPeople(g, 275, 325);
            } else if (choice == 3){
                drawNightSky(g);
                drawRainySky(g);
                drawWall(g,0,200);
                drawPeople(g,400,400);
                drawPeople(g,300,400);
                drawPeople(g,250,400);
                drawPeople(g,100,400);
                drawPeople(g, 425, 325);
                drawPeople(g, 325, 325);
                drawPeople(g, 275, 325);
            }
        }
    }
    // See if this code is useful later
    private void drawBuilding(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        g.drawRect(x,y,100,75);
        g.fillRect(x,y,100,75);
        g.setColor(Color.DARK_GRAY);
        int[] xPoints = {x-25,x+50,x+125};
        int[] yPoints = {y,y-50,y};
        g.drawPolygon(xPoints,yPoints,3);
        g.fillPolygon(xPoints,yPoints,3);
        g.setColor(Color.DARK_GRAY);
        g.drawRect(x+25,y+25,25,25);
        g.fillRect(x+25,y+25,25,25);
    }
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
    private void drawNightSky(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,500,500);
        drawMoon(g);
        drawGround(g);
    }
    private void drawSun(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(380,0,100,100);
        g.drawOval(380,0,100,100);
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
    private void drawClearSky(Graphics g){
        drawSun(g);
        drawGround(g);
    }
    private void drawClearNightSky(Graphics g){
        drawMoon(g);
        drawGround(g);
    }
    private void drawCloud(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,50,50);
        g.fillOval(x+25,y-25,50,50);
        g.fillOval(x+50,y,50,50);
        g.fillOval(x+25,y+10,50,50);
    }
    private void drawRain(Graphics g, int x, int y){
        g.setColor(Color.BLUE);
        g.drawLine(x,y,x-10,y+25);
        g.drawLine(x+10,y,x,y+25);
        g.drawLine(x+20,y,x+10,y+25);
        g.drawLine(x+30,y,x+20,y+25);
        g.drawLine(x+40,y,x+30,y+25);
    }
    private void drawRainCloud(Graphics g, int x, int y){
        drawCloud(g,x,y);
        for(int i=0; i<5; i++){
            drawRain(g,x+10*i+10,y+25);
        }
        drawGround(g);
    }
    private void drawCloudySky(Graphics g){
        drawCloud(g,50,50);
        drawCloud(g,200,100);
        drawCloud(g,350,50);
        drawGround(g);
    }
    private void drawRainySky(Graphics g){
        drawRainCloud(g,50,50);
        drawRainCloud(g,200,100);
        drawRainCloud(g,350,50);
        drawGround(g);
    }
}