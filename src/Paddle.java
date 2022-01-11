import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Rectangle;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Paddle extends Rectangle implements KeyListener, Runnable {
	private int x = 0;
	private double y = 0;
	private int playerNumber;
	private int screenWidth, screenHeight;
	Graphics graph;
	Thread thread;

	public Paddle(int x, double y, int width, int height, int playerNumber, int screenWidth, int screenHeight) {
		super(x, (int) y, width, height);
		this.x = x;
		this.y = y;
		this.playerNumber = playerNumber;
		thread = new Thread(this);
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		// System.out.println("Screen Width: " + this.screenWidth +" and Screen Height:
		// " + this.screenHeight);

	}

	public void paint(Graphics g) {
		if (playerNumber == 1)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		g.fillRect(x, (int) y, width, height);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (playerNumber) {
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_UP)
				if (y == 0)
					y = y;
				else
					move(-10);

			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				if (y == 410)
					y = y;
				else
					move(10);
			break;

		case 2:
			if (e.getKeyCode() == KeyEvent.VK_W)
				if (y == 0)
					y = y;
				else
					move(-10);

			else if (e.getKeyCode() == KeyEvent.VK_S)
				if (y == 410)
					y = y;
				else
					move(10);
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		move(0);

	}

	@Override
	public void run() {
		move(-10);

	}

	public void move(int step) {
		y += step;
	}

	public int getXPos() {
		return x;
	}

	public int getYPos() {
		return (int) y;
	}
}
