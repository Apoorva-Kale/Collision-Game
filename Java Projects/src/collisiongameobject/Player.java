package collisiongameobject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import CollisionGameApp.GlobalPosition;
import collisiongameinput.Controller;

public class Player extends GlobalPosition{
	private String playerimage = "/images/player.png";
	
	static LinkedList<Enemy> e = Controller.getEnemyBounds();
	
	int velX = 0;
	int velY = 0;

	public Player(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		x+=velX;
		y+=velY;
		
		// to keep the player from moving out of the screen in the left direction
		if(x < 0) {
			x=1;
		}
		
		// to keep the player from moving out of the screen in the upward direction
		if(y < 0) {
			y=1;
		}
				
		// to keep the player from moving out of the screen in the right direction
		if(x > 591) {
			x=591;
		}
		
		// to keep the player from moving out of the screen in the downward direction
		if(y > 403) {
			y=403;
		}
		
		Collision();
	}
	
	public void Collision() {
		for(int i=0;i<e.size();i++) {
			if(getBounds().intersects(e.get(i).getBounds())) {
				System.out.println("Collision");
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) { 	// to move right
			velX = 5;
		}else if(key == KeyEvent.VK_LEFT) { 	// to move left
			velX = -5;
		}else if(key == KeyEvent.VK_DOWN) { 	// to move down
			velY = 5;
		}else if(key == KeyEvent.VK_UP) { 	// to move up
			velY = -5; 
		}	
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 49, 47); // creates rectangle around the player, comment this line to see the rectangle
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			velX = 0;
		}else if(key == KeyEvent.VK_LEFT) {
			velX = 0;
		}else if(key == KeyEvent.VK_DOWN) {
			velY = 0;
		}else if(key == KeyEvent.VK_UP) {
			velY = 0;
		}
	}	
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImage(), x, y, null);
		g2d.draw(getBounds());
	}
	
	// method to add player image 
	public Image getPlayerImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(playerimage));
		return i.getImage();
	}

}
