import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Scene extends JPanel implements ActionListener {
    
    private final int SCENE_WIDTH = 800;
    private final int SCENE_HEIGHT = 600;
    
    private int numTrees = 40;
    private int numFlowers = 20;
    private final int numGrass = 100;
    private final int numClouds = 10; 
    private final int numBirds = 3;   
    private final int numAnimals = 5; 
    private JButton redrawButton;
    private JTextField treeInput;
    private JTextField flowerInput;
    private JLabel treeLabel;
    private JLabel flowerLabel;

    public Scene() {
        this.setLayout(null);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(SCENE_WIDTH, SCENE_HEIGHT));

        treeLabel = new JLabel("Trees:");
        treeLabel.setBounds(10, 10, 50, 25);
        this.add(treeLabel);
        
        treeInput = new JTextField(String.valueOf(numTrees));
        treeInput.setBounds(60, 10, 50, 25);
        this.add(treeInput);

        flowerLabel = new JLabel("Flowers:");
        flowerLabel.setBounds(120, 10, 60, 25);
        this.add(flowerLabel);
        
        flowerInput = new JTextField(String.valueOf(numFlowers));
        flowerInput.setBounds(180, 10, 50, 25);
        this.add(flowerInput);

        // redraw button
        redrawButton = new JButton("Redraw Scene");
        redrawButton.setBounds(250, 10, 150, 25);
        redrawButton.addActionListener(this);
        this.add(redrawButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();

        // draw background
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT / 2);
        
        // draw ground
        int groundY = SCENE_HEIGHT / 2 - 50;
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, groundY, SCENE_WIDTH, SCENE_HEIGHT - groundY);
        
        // draw clouds and birds
        for (int i = 0; i < numClouds; i++) {
            int cloudX = rand.nextInt(SCENE_WIDTH);
            int cloudY = rand.nextInt(groundY - 100); 
            drawCloud(g, cloudX, cloudY);
        }
        
        for (int i = 0; i < numBirds; i++) {
            int birdX = rand.nextInt(SCENE_WIDTH);
            int birdY = rand.nextInt(groundY - 150) + 50; 
            drawBird(g, birdX, birdY);
        }

        int minY = groundY + 10;
        int maxY = SCENE_HEIGHT - 20;

        // draw trees
        for (int i = 0; i < numTrees; i++) {
            int treeX = rand.nextInt(SCENE_WIDTH - 50);
            int treeY = rand.nextInt(maxY - minY) + minY;
            drawTree(g, treeX, treeY);
        }

        // draw flowers
        for (int i = 0; i < numFlowers; i++) {
            int flowerX = rand.nextInt(SCENE_WIDTH);
            int flowerY = rand.nextInt(maxY - minY) + minY;
            drawFlower(g, flowerX, flowerY);
        }

        // draw grass
        for (int i = 0; i < numGrass; i++) {
            int grassX = rand.nextInt(SCENE_WIDTH);
            int grassY = rand.nextInt(maxY - minY) + minY;
            drawGrass(g, grassX, grassY);
        }
        
        // draw animals
        for (int i = 0; i < numAnimals; i++) {
            int animalX = rand.nextInt(SCENE_WIDTH - 20);
            int animalY = rand.nextInt(maxY - minY) + minY;
            drawAnimal(g, animalX, animalY);
        }
    }
    // draw tree
    private void drawTree(Graphics g, int x, int y) {
        int trunkWidth = 10;
        int trunkHeight = 30;
        int leavesSize = 40;
        
        g.setColor(new Color(139, 69, 19));
        g.fillRect(x - trunkWidth / 2, y - trunkHeight, trunkWidth, trunkHeight);

        g.setColor(new Color(0, 100, 0));
        g.fillOval(x - leavesSize / 2, y - trunkHeight - (leavesSize / 2), leavesSize, leavesSize);
    }
    // draw flower
    private void drawFlower(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        g.drawLine(x, y, x, y - 10);

        g.setColor(Color.RED);
        g.fillOval(x - 3, y - 13, 6, 6);
    }
    // draw grass
    private void drawGrass(Graphics g, int x, int y) {
        g.setColor(new Color(50, 200, 50));
        g.drawLine(x, y, x, y - 3);
    }
    // draw cloud
    private void drawCloud(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 40, 20);
        g.fillOval(x + 15, y - 5, 30, 15);
        g.fillOval(x + 5, y + 5, 30, 15);
    }
    // draw bird
    private void drawBird(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawLine(x, y, x + 5, y - 5);
        g.drawLine(x + 5, y - 5, x + 10, y);
    }
    // draw animal
    private void drawAnimal(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 5, 5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redrawButton) {
            try {
                int newNumTrees = Integer.parseInt(treeInput.getText().trim());
                int newNumFlowers = Integer.parseInt(flowerInput.getText().trim());

                numTrees = newNumTrees;
                numFlowers = newNumFlowers;

                repaint(); 
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for trees and flowers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}