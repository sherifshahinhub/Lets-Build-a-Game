package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class WaveOfBasicEnemy extends GameObject{
	Handler handler;
	public WaveOfBasicEnemy(final float x, final float y, final ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		x += 8;
	}

	@Override
	public void render(final Graphics g) {
//		g.setColor(Color.ORANGE);
//		g.fillRect((int)x, (int)y, 16, 16);
		g.setColor(Color.ORANGE);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval((int)x, (int)y, 18, 18);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 18, 18);
	}

}
