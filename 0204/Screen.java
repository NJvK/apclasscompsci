import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Screen extends JPanel implements ActionListener{
    ArrayTest test;
    ArrayList<Card> cards;

    private JButton scrambleButton;
    private JButton sortButton;

    public Screen() {
        test = new ArrayTest();
        cards = new ArrayList<Card>();
        cards.add(new Card(5));
        cards.add(new Card(10));
        cards.add(new Card(7));
        cards.add(new Card(3));
        cards.add(new Card(8));

        scrambleButton = new JButton();
        sortButton = new JButton();

        scrambleButton.setBounds(50, 600, 100, 30);
        add(scrambleButton);
        scrambleButton.addActionListener(this);

        sortButton.setBounds(50, 700, 100, 30);
        add(sortButton);
        sortButton.addActionListener(this);
        
        setLayout(new FlowLayout());
        add(sortButton);
        add(scrambleButton);
        
    }

    @Override
	public Dimension getPreferredSize() {
		return new Dimension(1520,880);
	}

    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        int x = 30;
        int y = 80;
        for (Card cd : cards) {
            cd.drawMe(g, x, y);
            x += 60;
        }
	}

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == scrambleButton) {
            test.scramble(cards);
        } else if (e.getSource() == sortButton) {
            test.sort(cards);
        }
    	repaint();
    }
}