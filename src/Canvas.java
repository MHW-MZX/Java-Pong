import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Canvas extends JFrame {
JPanel panel;
JLabel label;
 
/**
 * Default Constructor for the Canvas Class
 */
	public Canvas() {
		
		this.setSize(new Dimension(500,500));
		this.setTitle("Pong Made By Malik Zurkiyeh");
		this.getContentPane().setBackground(Color.black);
		this.add(new Panel(this.getWidth(),this.getHeight()));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		System.out.printf("JFrame width: %d and height: %d ", this.getWidth(),this.getHeight());
		
	}
}
