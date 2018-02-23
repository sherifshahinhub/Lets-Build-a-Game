package gamePackage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class KeyInput extends KeyAdapter {
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	private final Handler handler;
	

	public KeyInput(final Handler handler) {
		this.handler = handler;
		up = false;
		down = false;
		left = false;
		right = false;
	}

	@Override
	public void keyPressed(final KeyEvent e) {
		if (Game.GameState == Game.GameState.Game) {
			final int key = e.getKeyCode();
			final GameObject tempObject = handler.object.get(0); // the first
																	// player
			int vel = 10;
			if (key == KeyEvent.VK_UP) {
				up = true;
				tempObject.setVelY(-1 * vel);
			}
			if (key == KeyEvent.VK_DOWN) {
				down = true;
				tempObject.setVelY(vel);
			}
			if (key == KeyEvent.VK_LEFT) {
				left = true;
				tempObject.setVelX(-1 * vel);
			}
			if (key == KeyEvent.VK_RIGHT) {
				right = true;
				tempObject.setVelX(vel);
			}
			if (key == KeyEvent.VK_ESCAPE) {
				final int a = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit");
				if (a == 0) {
					System.exit(1);
				}
			}
			if (key == KeyEvent.VK_SPACE) {
				if (Game.paused) {
					Game.paused = false;
				} else {
					Game.paused = true; 
				}
			}
		}
	}

	@Override
	public void keyReleased(final KeyEvent e) {
		if (Game.GameState == Game.GameState.Game) {
			final int key = e.getKeyCode();
			final GameObject object = handler.object.get(0); // the first player

			if (key == KeyEvent.VK_UP) {
				// object.setVelY(0);
				up = false;
			}
			if (key == KeyEvent.VK_DOWN) {
				// object.setVelY(0);
				down = false;
			}
			if (key == KeyEvent.VK_LEFT) {
				// object.setVelX(0);
				left = false;
			}
			if (key == KeyEvent.VK_RIGHT) {
				// object.setVelX(0);
				right = false;
			}
			if (!up && !down) {
				object.setVelY(0);
			}
			if (!left && !right) {
				object.setVelX(0);
			}

		}
	}
}
