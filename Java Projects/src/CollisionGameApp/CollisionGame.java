package CollisionGameApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import collisiongameinput.Controller;
import collisiongameinput.KeyInput;
import collisiongameobject.Player;

public class CollisionGame extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	Timer gamelooptimer;
	private String background = "/images/background.png";
	int speed = 5;
	
	//OBJECTS
	Player p;
	Controller c;
	
	//constructor
	public CollisionGame() {
		setFocusable(true);
		
		gamelooptimer = new Timer(10, this);
		gamelooptimer.start();
		
		p = new Player(300, 200);
		c = new Controller();
		
		addKeyListener(new KeyInput(p));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		
		p.draw(g2d);
		c.draw(g2d);
	}
	
	// method to add background image
	public Image getBackgroundImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		p.update();
		c.update();
		repaint();
	}

}
