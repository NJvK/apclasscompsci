import java.awt.Color;
import java.awt.Graphics;

public class Backgrounds{

    private int[] stars = new int[100];
   
    private void drawStars(Graphics g){
        Color white = new Color(255,255,255);
        g.setColor(white);
        for(int i = 0; i<stars.length; i++){
            int starx = (int)(Math.random()*801);
            int stary = (int)(Math.random()*601);
            g.fillOval(starx,stary,3,3);
        }
    }
    
    public void drawBackground1(Graphics g){
        Color black = new Color(0,0,0);
        g.setColor(black);
        g.fillRect(0,0,800,600);
        
        drawStars(g);
    }

    public void drawBackground2(Graphics g){
        Color blue = new Color(1,1,50);
        g.setColor(blue);
        g.fillRect(0,0,800,600);

        drawStars(g);
    }

    public void drawBackground3(Graphics g){
        Color red = new Color(40,0,0);
        g.setColor(red);
        g.fillRect(0,0,800,600);

        drawStars(g);
    }
}