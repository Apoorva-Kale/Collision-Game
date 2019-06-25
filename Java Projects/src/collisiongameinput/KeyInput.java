package collisiongameinput;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import collisiongameobject.Player;

// class to move the player with your keyboard
public class KeyInput extends KeyAdapter{
	
	// call player
	Player p;
	
	// constructor
	public KeyInput(Player p) {
		this.p = p;
	}
	
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
}
