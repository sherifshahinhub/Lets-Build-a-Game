package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Random;

public class MenuParticle extends GameObject{
	Random r = new Random();
	Color col;
	public MenuParticle(int x, int y, ID id) {
		super(x, y, id);
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
		int dir = r.nextInt(3);
		if (dir == 0) {
			velX = 2;
			velY = 5;
		} else if (dir == 1){
			velX = 5;
			velY = 2;
		} else if (dir == 2){
			velX = 9;
			velY = 2;
		}
		  else if (dir == 3){
			velX = 2;
			velY = 9;
		}
		
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
		
		g.setColor(col);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval((int)x, (int)y, 20, 20);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
