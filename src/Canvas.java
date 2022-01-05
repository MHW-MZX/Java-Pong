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
Paddle pad1,pad2;
	public Canvas() {
		pad1 = new Paddle(5,10,1);
		pad2 = new Paddle(400,10,2);
		this.setSize(new Dimension(500,500));
		this.getContentPane().setBackground(Color.black);
		this.add(pad2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}
}
