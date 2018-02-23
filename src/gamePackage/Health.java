package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class Health extends GameObject{
	float x, y;
	public Health(float x, float y, ID id) {
		super(x, y, id);
		this.x = x;
		this.y = y;
	}
	Color color = new Color(255, 0, 255);
	@Override
	public void render(final Graphics g) {
		g.setColor(color);
		g.drawString("HEALTH", (int)x, (int)y);
		
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval((int)x, (int)y, 20, 20);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
