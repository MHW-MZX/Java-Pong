import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import javax.swing.JPanel;

/**
 * 
 * @author Malik Zurkiyeh
 *
 */
public class Panel extends JPanel implements KeyListener, Runnable {

	private static final long serialVersionUID = 1L;
	Thread thread;
	Paddle pad1, pad2;
	Ball ball;
	private int screenWidth;
	private int screenHeight;
	
	public Panel(int sWidth, int sHeight) {
		this.setBackground(Color.BLACK);
		addPaddles();
		addBall();
		this.screenWidth = sWidth;
		this.screenHeight = sHeight;
		
		
		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		pad1.paint(g);
		pad2.paint(g);
		ball.paint(g);
		

	}

	private void addPaddles() {
		System.out.println("Adding Paddles Screen Width: " + screenWidth +" and Screen Height: " + screenHeight);
		pad1 = new Paddle(0, 50, 15, 60, 1,screenWidth,screenHeight);
		pad2 = new Paddle(470, 50, 15, 60, 2,screenWidth,screenHeight);
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
	}

	private void addBall() {
		ball = new Ball(250,250,10,10,screenWidth,screenHeight);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		pad1.keyPressed(e);
		pad2.keyPressed(e);

	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		pad1.keyReleased(e);
		pad2.keyReleased(e);

	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				System.out.println(pad1.getYPos());
				moveBall();
				collisionDetection();
				repaint();
				delta--;
			}
		}
	}
	
	private void moveBall() {
		ball.move();
	}
	
	private void collisionDetection() {
		if(pad1.intersects(ball)) {
			System.out.println(pad2.intersects(ball));
			ball.setXVelocity(-2);
			ball.setYVelocity(2);
		}
	}
	
	
}
