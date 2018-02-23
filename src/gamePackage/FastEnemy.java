package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class FastEnemy extends GameObject{

	public FastEnemy(int x, int y, ID id) {
		super(x, y, id);
		velX = 3;
		velY = 6;
	}

	@Override
	public void tick() {
		x = x + velX;
		y = y + velY;
		if (y <= 0 || y >= Game.HEIGHT - 32) {
			velY = velY * -1;
		} else if (x <= 0 || x >= Game.WIDTH - 16) {
			velX = velX * -1;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval((int)x, (int)y, 20, 20);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
