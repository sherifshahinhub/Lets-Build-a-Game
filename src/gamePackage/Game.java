package gamePackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	public static int WIDTH = 640;
	public static int HEIGHT = WIDTH / 12 * 9; // 480
	private Thread thread;
	public static boolean running = false;
	private Random r = new Random();
	private Handler handler;
	private Handler handler2;
	private Handler menuHandler;
	private HUD hud;
	private Spown sponer;
	private Menu menu;
	private boolean menuToGame = false;
	private BufferedImage Sprite_Sheet;
	public static boolean  paused = false;
	public static int diff; //0 = easy  1 = hard
	
	public static void main(final String args[]) {
		new Game();
	}
	
	Game() {
		hud = new HUD();
		handler = new Handler();
		handler2 = new Handler();
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new Menu(this, menuHandler, hud));
		Window window = new Window(WIDTH, HEIGHT, "Let's Paly a Game!", this);
		
		BufferedImageLouder loader =  new BufferedImageLouder();
//		Sprite_Sheet = loader.loadImage("/SpriteSheet.png");
		
		sponer = new Spown(handler, hud);
		menu = new Menu(this, menuHandler, hud);
		if (GameState == GameState.Menu) {
			menuToGame = true;
			for (int i = 0; i < 20; i++) {
				handler2.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT) - 32, ID.MenuParticle));
			}
		}
		
	}

	public enum STATE {
		Game, Help, Select, Menu, End
	};

	public static STATE GameState = STATE.Menu;

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static float clamp(float var, final float max, final float min) {
		if (var <= min) {
			return var = min;
		} else if (var >= max) {
			return var = max;
		} else {
			return var;
		}
	}

	public static int clamp(int var, final int max, int min) {
		if (var <= min) {
			return var = min;
		} else if (var >= max) {
			return var = max;
		} else {
			return var;
		}
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		final double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			final long now = System.nanoTime();
			delta = delta + (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			if (System.currentTimeMillis() - timer > 1000) {
				timer = timer + 1000;
			}
		}
		stop();
	}

	private void tick() {
		
		if (GameState != GameState.Game) {
			handler2.tick();
		}
		if (GameState == STATE.Game && !paused) {
			handler.tick();
			hud.tick();
			sponer.tick();
			if (HUD.HEALTH <= 0) {
				HUD.HEALTH = 200;
				hud.setLevel(1);
				if (hud.getScore() != 0) {
					menu.score = hud.getScore();
				}
				hud.setScore(0);
				GameState = STATE.End;
				handler.clearEnemys();
			}
		} 
		if (GameState == STATE.Menu || GameState == STATE.End || GameState == STATE.Select) {
			menu.tick();
			handler.tick();
		}
	}
	
	private void render() {
		final BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		final Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		if (GameState != GameState.Game) {
			handler2.render(g);
		}
		
		if (paused) {
			g.setFont(new Font("Arial",1 , 30));
			g.setColor(Color.YELLOW);
			g.drawString("PAUSED", WIDTH / 2 - 60, HEIGHT / 2 );
			g.setFont(new Font("Arial",1 , 11));
		}
		
		if (GameState == STATE.Game) {
			hud.render(g);
			g.setFont(new Font("Arial",1 , 20));
			g.setColor(Color.WHITE);
			g.drawString("Level ", WIDTH / 2 - 60, 40);
			g.setColor(Color.YELLOW);
			g.drawString("" + (int)hud.getLevel(), WIDTH / 2, 40); 
			
			
		} else if (GameState == STATE.Menu || GameState == STATE.Help || GameState == STATE.End || GameState == STATE.Select) {
			menu.render(g);
		}
		g.dispose();
		bs.show();

	}
}
