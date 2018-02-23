package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BigBossBullet extends GameObject{
	Handler handler;
	Random r = new Random();
	
	public BigBossBullet(final float x, final float y, final ID id, Handler h) {
		super(x, y, id);
		this.handler = h;
		do {
		velY = (r.nextInt(3 - -3) + -3);
		velX = (r.nextInt(3 - -3) + -3);
		} while (velY == 0 || velX == 0);
		
	}

	@Override
	public void tick() {
		x = x + velX;
		y = y + velY;
		
		if (y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
