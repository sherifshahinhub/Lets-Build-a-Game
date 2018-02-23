package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Random;

public class HardEnemy extends GameObject{
	Handler handler;
	Random r;
	public HardEnemy(final float x, final float y, final ID id) {
		super(x, y, id);
		r = new Random();
		velY = 3;
		velX = 3;
	}

	@Override
	public void tick() {
		x = x + velX;
		y = y + velY;
		if (y <= 0 || y >= Game.HEIGHT - 32) {
			if (velY < 0) {
				velY = -(r.nextInt(7) + 2) * -1;
			} else {
				velY = (r.nextInt(7) + 2) * -1;
			}
		} else if (x <= 0 || x >= Game.WIDTH - 16) {
			if (velX < 0) {
				velX = -(r.nextInt(7) + 1) * -1;
			} else {
				velX = (r.nextInt(7) + 1) * -1;
			}
		}
	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.red);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval((int)x, (int)y, 20, 20);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 20, 20);
	}

}
