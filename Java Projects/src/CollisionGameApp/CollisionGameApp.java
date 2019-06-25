package CollisionGameApp;

import javax.swing.JFrame;

public class CollisionGameApp {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.pack();
		frame.add(new CollisionGame());
		frame.setSize(640,480);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
