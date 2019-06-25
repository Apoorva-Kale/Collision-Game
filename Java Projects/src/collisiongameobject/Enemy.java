package collisiongameobject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import CollisionGameApp.GlobalPosition;

public class Enemy extends GlobalPosition{
	
	int speed = 5;
	private String image = "/images/enemy.png";
	
	public Enemy(int x, int y) {
		super(x, y);
	}
	
	public void update() {
		x+=speed;
		
		if(x > 598) {
			speed = -5;
		} 
		
		if(x < 0) {
			speed = 5;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32); // creates rectangle around the player, comment this line to see the rectangle
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImage(), x, y, null);
	}
	
	public Image getEnemyImage() {
		ImageIcon i = new ImageIcon(getClass().getResource(image));
		return i.getImage();
	}

}
