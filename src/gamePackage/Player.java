package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JOptionPane;

public class Player extends GameObject {
	Handler h;
	boolean lose = false;

	public Player(final int x, final int y, final ID id, Handler handler) {
		super(x, y, id); // super -> GameObject
		this.h = handler;
	}

	@Override
	public void tick() {
		x = x + velX;
		y = y + velY;
		x = Game.clamp((int) x, Game.WIDTH - 38, 0);
		y = Game.clamp((int) y, Game.HEIGHT - 60, 0);

		collision();
	}

	private void collision() {
		for (int i = 0; i < h.object.size(); i++) {
			GameObject tempObject = h.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision
					HUD.HEALTH--;
				}
			}
			if (tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.WaveBasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision
					HUD.HEALTH--;
				}
			}
			if (tempObject.getId() == ID.BigBoss || tempObject.getId() == ID.FastSmartEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision
					HUD.HEALTH--;
				}
			}
			if (tempObject.getId() == ID.BigBasicEnemy || tempObject.getId() == ID.SecondBigBoss) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision
					HUD.HEALTH--;
				}
			}
			if (tempObject.getId() == ID.WaveEnemy || tempObject.getId() == ID.RandomWaveOfBasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision
					HUD.HEALTH--;
				}
			}
			if (tempObject.getId() == ID.RandomWaveOfBasicEnemyR || tempObject.getId() == ID.RandomWaveOfBasicEnemyUp) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision
					HUD.HEALTH--;
				}
			}
			if (tempObject.getId() == ID.RandomWaveOfBasicEnemyDown) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision
					HUD.HEALTH--;
				}
			}
			if (tempObject.getId() == ID.Health) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH = HUD.HEALTH + 50;
					for (int j = 0; j < h.object.size(); j++) {
						if (h.object.get(j).id == ID.Health && h.object.get(j) == tempObject) {
							h.object.remove(j);
							break;
						}
					}
				}
			}

		}
		
	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.white);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillRect((int) x, (int) y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

}
