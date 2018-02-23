package gamePackage;

import java.awt.Color;
import java.awt.Graphics;

public class HUD { 

	public static int HEALTH = 200;
	int green = 255;
	float level = 1, score = 0;
	
	public void tick() {
		HEALTH = (int) Game.clamp(HEALTH, 200, 0);
		green = Game.clamp(green, 255, 0);
		green = HEALTH;
		score++;
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);

		g.setColor(new Color(100, green, 0));
		g.fillRect(15, 15, HEALTH, 32);

		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score = " + (int)score, 15, 64);
		g.drawString("Level = " + (int)level, 15, 80);
	}
	
	public void setScore (int score) {
		this.score = score;
	}
	
	public float getScore() {
		return score;
	}
	public float getLevel() {
		return level;
	}
	public void setLevel(float level) {
		this.level = level;
	}	
}
