import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Background2 extends JPanel {

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

        Color lightGreen = new Color(43, 84, 49);
        
        //Washington monumnet:
        drawMonument(g);
        drawReflection(g);
        
        int[] xArray = new int[4];
        int[] yArray = new int[4];

        //grass 1:
        //Point 1
        xArray[0] = 0;
        yArray[0] = 300;

        //Point2
        xArray[1] = 300;
        yArray[1] = 300;

        //Point3
        xArray[2] = 100;
        yArray[2] = 600;

        //Point4
        xArray[3] = 0;
        yArray[3] = 600;


        g.setColor(lightGreen);
        g.fillPolygon(xArray, yArray, 4);

        //grass 2:
        //point
        xArray[0] = 800;
        yArray[0] = 300;

        //Point2
        xArray[1] = 500;
        yArray[1] = 300;

        //Point3
        xArray[2] = 700;
        yArray[2] = 600;

        //Point4
        xArray[3] = 800;
        yArray[3] = 600;


        g.setColor(lightGreen);
        g.fillPolygon(xArray, yArray, 4);

        //Grass 3:
        g.setColor(lightGreen);
        g.fillRect(0,290,800,10);
 
        //Trees:
        drawFarTree(g,150,280,110,240);
        drawFarTree(g,650,280,620,240);

        drawMidTree(g,110,320,65,260);
        drawMidTree(g,690,320,660,260);

        drawCloseTree(g, 60, 360,10,280);
        drawCloseTree(g, 740, 360,700,280); 

        drawMcDonalds(g,270,250,280,260,295,260);
        drawMcDonalds(g,470,250,480,260,495,260);

        drawTourist(g, 250, 260, 250, 270);
        drawTourist(g, 230, 260, 230, 270);
        drawTourist(g, 210, 260, 210, 270);
        drawTourist(g, 540, 260, 540, 270);
        drawTourist(g, 560, 260, 560, 270);
        drawTourist(g, 580, 260, 580, 270);

        drawFlag(g,350, 250, 350, 250, 350, 255, 350, 250, 347, 250);
        drawFlag(g,380, 250, 380, 250, 380, 255, 380, 250, 377, 250);
        drawFlag(g,410, 250, 410, 250, 410, 255, 410, 250, 407, 250);
        drawFlag(g,440, 250, 440, 250, 440, 255, 440, 250, 437, 250);
        
        
    }
    public void drawCloseTree(Graphics g, int trunkX, int trunkY, int leavesX, int leavesY){
        
        //draw trunk at x and y
        Color lightBrown = new Color(88,57,39);
        g.setColor(lightBrown);
        g.fillRect(trunkX,trunkY,25,100);
        
        Color darkGreen = new Color(23, 64, 29);
        g.setColor(darkGreen);
        g.fillOval(leavesX,leavesY,120,120);
    }

    public void drawMidTree(Graphics g, int trunkX, int trunkY, int leavesX, int leavesY){
        Color lightBrown = new Color(88,57,39);
        g.setColor(lightBrown);
        g.fillRect(trunkX,trunkY,20,90);

        Color darkGreen = new Color(23, 64, 29);
        g.setColor(darkGreen);
        g.fillOval(leavesX,leavesY,100,100);
        
    }

    public void drawFarTree(Graphics g, int trunkX, int trunkY, int leavesX, int leavesY) {
        Color lightBrown = new Color(88,57,39);
        g.setColor(lightBrown);
        g.fillRect(trunkX,trunkY,15,80);
        
        Color darkGreen = new Color(23, 64, 29);
        g.setColor(darkGreen);
        g.fillOval(leavesX,leavesY,80,80);


    }

    public void drawMonument(Graphics g){
        Color tan = new Color(255, 252, 205);
        Color brown = new Color(210, 180, 140);
        int[] xArray = new int[5];
        int[] yArray = new int[5];

        

         //Point 1
        xArray[0] = 370;
        yArray[0] = 290;

        //Point 2
        xArray[1] = 445;
        yArray[1] = 290;

        //Point 3
        xArray[2] = 415;
        yArray[2] = 70;

        //Point 4
        xArray[3] = 400;
        yArray[3] = 55;

        //Point 5
        xArray[4] = 390;
        yArray[4] = 70;

        g.setColor(brown);
        g.fillPolygon(xArray,yArray,5);
        
        //Point 1
        xArray[0] = 370;
        yArray[0] = 290;

        //Point 2
        xArray[1] = 435;
        yArray[1] = 290;

        //Point 3
        xArray[2] = 410;
        yArray[2] = 70;

        //Point 4
        xArray[3] = 400;
        yArray[3] = 55;

        //Point 5
        xArray[4] = 390;
        yArray[4] = 70;

        g.setColor(tan);
        g.fillPolygon(xArray,yArray,5);


    }

    public void drawReflection(Graphics g){
        Color tan = new Color(255, 252, 205);
        Color brown = new Color(210, 180, 140);
        int[] xArray = new int[5];
        int[] yArray = new int[5];


        //Point 1
        xArray[0] = 370;
        yArray[0] = 290;

        //Point 2
        xArray[1] = 445;
        yArray[1] = 290;

        //Point 3
        xArray[2] = 415;
        yArray[2] = 510;

        //Point 4
        xArray[3] = 400;
        yArray[3] = 525;

        //Point 5
        xArray[4] = 390;
        yArray[4] = 510;

        g.setColor(brown);
        g.fillPolygon(xArray,yArray,5);
        
        //Point 1
        xArray[0] = 370;
        yArray[0] = 290;

        //Point 2
        xArray[1] = 435;
        yArray[1] = 290;

        //Point 3
        xArray[2] = 410;
        yArray[2] = 510;

        //Point 4
        xArray[3] = 400;
        yArray[3] = 525;

        //Point 5
        xArray[4] = 390;
        yArray[4] = 510;

        g.setColor(tan);
        g.fillPolygon(xArray,yArray,5);

    }

    public void drawMcDonalds(Graphics g, int basex, int basey, int arch1x, int arch1y, int arch2x, int arch2y){
        Color red = new Color(195,9,19);
        Color yellow = new Color(225,222,33);
        
        g.setColor(red);
        g.fillRect(basex,basey,60,40);

        g.setColor(yellow);
        g.drawArc(arch1x, arch1y, 15,30, 0,180);
         g.drawArc(arch2x, arch2y, 15,30, 0,180);
    }

    public void drawTourist(Graphics g, int headx, int heady, int torsox, int torsoy) {
        Color tan = new Color(255, 252, 205);
        Color red = new Color(195,9,19);

        g.setColor(tan);
        g.fillOval(headx, heady, 10, 10);
        g.setColor(red);
        g.fillRect(torsox, torsoy, 10,20);

    }

    public void drawFlag(Graphics g, int basex, int basey, int stripe1x, int stripe1y, int stripe2x, int stripe2y, int bluex, int bluey, int polex, int poley) {
        Color white = new Color(255,255,255);
        Color red = new Color(195,9,19);
        Color blue = new Color(15,82,186);
        Color grey = new Color(123,123,125);

        g.setColor(white);
        g.fillRect(basex, basey, 20,10);
        g.setColor(red);
        g.fillRect(stripe1x, stripe1y, 20, 3);
        g.fillRect(stripe2x, stripe2y, 20, 3);
        g.setColor(blue);
        g.fillRect(bluex, bluey, 7, 6);
        g.setColor(grey);
        g.fillRect(polex, poley, 3, 40);

    }

	
}
