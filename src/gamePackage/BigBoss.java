package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BigBoss extends GameObject {
	Handler handler;
	boolean stand = false;
	int timer = 150;
	Random r = new Random();

	public BigBoss(final float x, final float y, final ID id, Handler h) {
		super(x, y, id);
		velX = 3;
		this.handler = h;
	}

	@Override
	public void tick() {
		if (y <= 45) {
			y++;
			stand = true;
		}
		if (stand) {
			timer--;
		}
		if (timer <= 0) {
			x = x + velX;
			if (x <= 0 || x >= Game.WIDTH - 100) {
				velX = velX * -1;
			}
			if (Math.abs(velX) < 15 && Game.diff == 0) {
				if (velX < 0) {
					velX -= 0.01;
				} else {
					velX += 0.01;
				}
			} else if (Math.abs(velX) < 25 && Game.diff == 1) {
				if (velX < 0) {
					velX -= 0.01;
				} else {
					velX += 0.01;
				}
			}
			int spown = r.nextInt(15);
				if (spown == 5) {
					handler.addObject(new BigBossBullet((int) x, (int) y, ID.BasicEnemy, handler));
				}
				if (spown == 10) {
					handler.addObject(new BigBossBullet((int) x, (int) y, ID.BasicEnemy, handler));
				}
				if (spown == 15) {
					handler.addObject(new FastEnemy((int) x, (int) y, ID.FastEnemy));
				}
				if (spown == 1) {
					handler.addObject(new BigBossBullet((int) x, (int) y, ID.BasicEnemy, handler));
				}
				if (spown == 8) {
					handler.addObject(new BigBossBullet((int) x, (int) y, ID.BasicEnemy, handler));
				}
				if (Game.diff == 1) {
					if (spown == 10) {
						handler.addObject(new BigBossBullet((int) x, (int) y, ID.BasicEnemy, handler));
					}
					if (spown == 8) {
						handler.addObject(new BigBossBullet((int) x, (int) y, ID.BasicEnemy, handler));
					}
				}
		}

	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 100, 100);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 100, 100);
	}

}
