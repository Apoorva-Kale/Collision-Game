package collisiongameinput;

import java.awt.Graphics2D;
import java.util.LinkedList;

import collisiongameobject.Enemy;

// class to add more number of enemies
public class Controller {
	static LinkedList<Enemy> e = new LinkedList<Enemy>();
	
	Enemy tempEnemy;
	
	public Controller() {
		addEnemy(new Enemy(100, 100));
		addEnemy(new Enemy(20, 300));
		addEnemy(new Enemy(300, 70));
		addEnemy(new Enemy(200, 50));
		addEnemy(new Enemy(60, 200));
	}
	
	// draw all the enemies
	public void draw(Graphics2D g2d) {
		for(int i=0; i<e.size();i++) {
			tempEnemy = e.get(i);
			tempEnemy.draw(g2d);
		}
	}
	
	// update all the enemies
	public void update() {
		for(int i=0; i<e.size();i++) {
			tempEnemy = e.get(i);
			tempEnemy.update();
		}
	}
	
	public void addEnemy(Enemy enemy) {
		e.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		e.remove(enemy);
	}
	
	public static LinkedList<Enemy> getEnemyBounds(){
		return e; // will return value for each one from the LinkedList
	}
}
