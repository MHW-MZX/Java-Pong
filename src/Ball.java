
import java.awt.Rectangle;
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

public class Ball extends Rectangle {

	private static final long serialVersionUID = 1L;
	private int x;
	private double y;
	private int screenWidth;
	private int screenHeight;
	private double xVelocity = 2;
	private double yVelocity = 2;
	Thread thread;
	Graphics graph;

	public Ball(int x, double y, int width, int height, int screenWidth, int screenHeight) {
		super(x, (int) y, width, height);
		this.x = x;
		this.y = y;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		

	}

	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, (int) y, width, height);
	}

	public void move() {
		if ((getX() + width < 10 && getY() + height < 10) || (getX() + width >= 500 && getY() + height <= 500)) {
			setXVelocity(-xVelocity);
			setYVelocity(-yVelocity);
		} 
		x -= xVelocity;
		y -= yVelocity;
		
		//System.out.printf("%d %f\n", x, y);
	}

	public void setXVelocity(double xVel) {
		this.xVelocity = xVel;
	}

	public void setYVelocity(double yVel) {
		this.yVelocity = yVel;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return (int) y;
	}

}
