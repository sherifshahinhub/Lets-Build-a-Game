package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class SmartEnemy extends GameObject{
	Handler handler;
	GameObject player ;
	public SmartEnemy(final int x, final int y, final ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ID.Player) {
				player = handler.object.get(i);
			}
		}
	}

	@Override
	public void tick() {
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float) Math.sqrt(diffX * diffX + diffY * diffY);
		
		velX = (float) ((-1.0 / distance) * diffX);
		velY = (float) ((-1.0 / distance) * diffY);

		x = x + velX;
		y = y + velY;
	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.yellow);
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
