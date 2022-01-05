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

public class Paddle extends JPanel implements KeyListener {
	private int x = 0;
	private double y = 0;
	private int playerNumber;

	public Paddle(int x, double y, int playerNumber) {
		this.x = x;
		this.y = y;
		this.playerNumber = playerNumber;
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (playerNumber) {
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_UP)
				y -= 10;
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				y += 10;
			break;

		case 2:
			if(e.getKeyCode() == KeyEvent.VK_W)
				y -= 10;
			else if(e.getKeyCode() == KeyEvent.VK_S)
				y += 10;
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
