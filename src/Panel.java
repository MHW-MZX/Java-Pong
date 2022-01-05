import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int x = 0;
	private double y = 0;
	private int playerNumber;

	public Panel(int x, double y, int playerNumber) {
		this.x = x;
		this.y = y;
		this.playerNumber = playerNumber;
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.WHITE);
		g.fillRect(x, (int) y, 15, 80);

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
	public Panel() {
		
	}
}
