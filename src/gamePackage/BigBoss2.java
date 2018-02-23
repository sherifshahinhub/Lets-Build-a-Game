package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Random;

public class BigBoss2 extends GameObject{
	Handler handler;
	public BigBoss2(final float x, final float y, final ID id, Handler handler) {
		super(x, y, id);
		velY = 3;
		velX = 3;
		this.handler = handler;
	}

	@Override
	public void tick() {
		
		x = x + velX;
		y = y + velY;
		if (y <= 0 || y >= Game.HEIGHT - 150) {
			velY = velY * -1;
		} else if (x <= 0 || x >= Game.WIDTH - 150) {
			velX = velX * -1;
		}
		if (Math.abs(velX) < 10) {
			if (velX < 0) {
				velX -= 0.01;
			} else {
				velX += 0.01;
			}
		} 
		if (Math.abs(velY) < 10) {
			if (velY < 0) {
				velY -= 0.01;
			} else {
				velY += 0.01;
			}
		}
		Random r = new Random();
		int spown = r.nextInt(15);
		if (spown == 5) {
			handler.addObject(new RandomWaveOfBasicEnemy(x, y, ID.RandomWaveOfBasicEnemy));
		}
		if (spown == 10) {
			handler.addObject(new RandomWaveOfBasicEnemy(x, y, ID.RandomWaveOfBasicEnemy));
		}
		if (spown == 15) {
			handler.addObject(new RandomWaveOfBasicEnemy(x, y, ID.RandomWaveOfBasicEnemy));
		}
	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.GREEN);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval((int)x, (int)y, 150, 150);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 150, 150);
	}

}
