package gamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	public static float score;

	Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (game.GameState == game.GameState.Menu) {
			// Play
			if (mouseOver(mx, my, 200, 64, 210, 150)) {
				game.GameState = game.GameState.Select;
			}
			// Help
			else if (mouseOver(mx, my, 200, 64, 210, 250)) {
				game.GameState = game.GameState.Help;
			} else if (mouseOver(mx, my, 200, 64, 210, 350)) {
				System.exit(1);
			}
		}

		// Back button for help
		else if (Game.GameState == Game.GameState.Help) {
			if (mouseOver(mx, my, 200, 64, 210, 350)) {
				Game.GameState = Game.GameState.Menu;
				return;
			}
		} else if (Game.GameState == Game.GameState.End) {
			if (mouseOver(mx, my, 200, 64, 210, 350)) {
				Game.GameState = Game.GameState.Menu;
			}
		} else if (game.GameState == game.GameState.Select) {
			// Easy
			if (mouseOver(mx, my, 200, 64, 210, 150)) {
				Game.diff = 0;
				game.GameState = game.GameState.Game;
			}
			// Hard
			else if (mouseOver(mx, my, 200, 64, 210, 250)) {
				game.diff = 1;
				game.GameState = game.GameState.Game;
			}
			//Back
			else if (mouseOver(mx, my, 200, 64, 210, 350)) {
				game.GameState = game.GameState.Menu;
			}
		}

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void tick() {

	}

	private boolean mouseOver(int mx, int my, int width, int height, int x, int y) {
		if (mx > x && mx < x + width && my > y && my < y + height) {
			return true;
		}
		return false;
	}

	public void render(Graphics g) {
		if (Game.GameState == Game.GameState.Menu) {
			Font font = new Font("Arial", 1, 50);
			Font font1 = new Font("Arial", 1, 30);

			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString("Menu", 240, 70);

			g.drawRect(210, 150, 200, 64);
			g.setFont(font1);
			g.drawString("Play", 270, 190);

			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 270, 290);

			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 390);

		} else if (Game.GameState == Game.GameState.Help) {
			Font font = new Font("Arial", 1, 50);
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString("Help", 240, 70);

			Font font1 = new Font("Arial", 1, 30);
			g.setFont(font1);
			g.drawString("1 - Use The arrows buttons to control", 50, 100);
			g.drawString("     Your Player and dodge Enemies !", 50, 150);
			g.drawString("2 - Space Button to Pause", 50, 200);
			g.setColor(Color.YELLOW);
			g.drawString("This Game GUI and code implementation was made by :", 50, 250);
			g.drawString(" was made by :", 50, 300);
			g.drawString("Eng: Sherif Mohammed Shahin ", 50, 350);

			g.setColor(Color.WHITE);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);

		} else if (Game.GameState == Game.GameState.End) {
			Font font = new Font("Arial", 1, 30);
			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString("Game Over", 240, 70);

			Font font1 = new Font("Arial", 1, 30);
			g.setColor(Color.YELLOW);
			g.drawString("       You lost With Score of : " + (int) score, 50, 250);
			g.setColor(Color.WHITE);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 245, 390);

		} else if (Game.GameState == Game.GameState.Select) {
			Font font = new Font("Arial", 1, 50);
			Font font1 = new Font("Arial", 1, 30);

			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString("Select Difficulty", 130, 70);

			g.drawRect(210, 150, 200, 64);
			g.setFont(font1);
			g.drawString("Easy", 270, 190);

			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 270, 290);

			g.drawRect(210, 350, 200, 64);
			g.setColor(Color.YELLOW);
			g.drawString("Back", 270, 390);

		}

	}
}