package gamePackage;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;

public class Spown {
	private Handler handler;
	private Player player;
	private HUD hud;
	private int scoreKeep = 0;
	Random r = new Random();
	boolean wave1 = true, wave2 = false, wave3 = false;

	public Spown(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	boolean first = true;

	public void tick() {
		if (Game.diff == 0) { //easy
			if (hud.getLevel() == 1 && first) {
				handler.addObject(new Player(640 / 2 - 32, 480 / 2 - 32, ID.Player, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
				first = false;
			}
			scoreKeep++;
			if (scoreKeep >= 500) {
				scoreKeep = 0;
				hud.setLevel(hud.getLevel() + 1);
				if (wave1) {
					firstWaveEasy();
				} else if (wave2) {
					secondWaveEasy();
				}
			} else if (scoreKeep == 400 && wave2) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
				}

			} else if (scoreKeep == 800 && wave2) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(new RandomWaveOfBasicEnemyR(640, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
				}

			} else if (scoreKeep == 200 && hud.getLevel() % 2 == 0 && wave2) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(
							new RandomWaveOfBasicEnemyUp(r.nextInt(Game.WIDTH), Game.HEIGHT - 32, ID.BasicEnemy));
				}

			} else if (scoreKeep == 200 && hud.getLevel() % 2 == 1 && wave2) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(new RandomWaveOfBasicEnemyDown(r.nextInt(Game.WIDTH), 0, ID.BasicEnemy));
				}
			}
		} else if (Game.diff == 1) { //Hard
			if (hud.getLevel() == 1 && first) {
				handler.addObject(new Player(640 / 2 - 32, 480 / 2 - 32, ID.Player, handler));
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
				first = false;
			}
			scoreKeep++;
			if (scoreKeep >= 1000) {
				scoreKeep = 0;
				hud.setLevel(hud.getLevel() + 1);
				if (wave1) {
					firstWaveHard();
				} else if (wave2) {
					secondWaveHard();
				}
			} else if (scoreKeep == 400) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
				}

			} else if (scoreKeep == 800) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(new RandomWaveOfBasicEnemyR(640, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
				}

			} else if (scoreKeep == 200 && hud.getLevel() % 2 == 0) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(
							new RandomWaveOfBasicEnemyUp(r.nextInt(Game.WIDTH), Game.HEIGHT - 32, ID.BasicEnemy));
				}

			} else if (scoreKeep == 200 && hud.getLevel() % 2 == 1) {
				int random;
				do {
					random = r.nextInt(10);
				} while (random <= 4);
				for (int i = 0; i < random; i++) {
					handler.addObject(new RandomWaveOfBasicEnemyDown(r.nextInt(Game.WIDTH), 0, ID.BasicEnemy));
				}
			}
		}
	}

	Font font = new Font("arial", 1, 200);

	private void firstWaveEasy() {

		if (hud.getLevel() == 2) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
		} else if (hud.getLevel() == 3) {
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
		} else if (hud.getLevel() == 4) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			// handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),
			// r.nextInt(Game.HEIGHT) - 32, ID.FastEnemy));
		} else if (hud.getLevel() == 5) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			// handler.addObject(
			// new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) -
			// 32, ID.SmartEnemy, handler));
		} else if (hud.getLevel() == 6) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
		} else if (hud.getLevel() == 7) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
		} else if (hud.getLevel() == 8) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
		} else if (hud.getLevel() == 9) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
		} else if (hud.getLevel() == 10) {
			handler.clearEnemys();
			handler.addObject(new BigBoss(Game.WIDTH / 2 - 100, -100, ID.BigBoss, handler));
		} else if (hud.getLevel() == 15) {
			handler.clearEnemys();
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 16) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 17) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 18) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 19) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 20) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
			wave1 = false;
			wave2 = true;
		}

	}

	public void secondWaveEasy() {
		if (hud.getLevel() == 20) {
			handler.clearEnemys();
			handler.addObject(new RandomWaveOfBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32,
					ID.RandomWaveOfBasicEnemy));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));

		}
		if (hud.getLevel() == 22) {
			handler.clearEnemys();
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
		}
		if (hud.getLevel() == 24) {
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.FastEnemy));
		}
		if (hud.getLevel() == 26) {
			handler.addObject(
					new FastSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.FastSmartEnemy, handler));
		} else if (hud.getLevel() == 27) {
			handler.clearEnemys();
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 28) {
			handler.clearEnemys();
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 29) {
			handler.clearEnemys();
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 30) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 31) {
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 32) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 33) {
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 34) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 35) {
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 39) {
			handler.clearEnemys();
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
		} else if (hud.getLevel() == 40) {
			handler.addObject(
					new BigBoss2(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.SecondBigBoss, handler));
		} else if (hud.getLevel() == 45) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
		} else if (hud.getLevel() == 50) {
			JOptionPane.showMessageDialog(null, "You Won");
			Game.GameState = Game.GameState.End;
		}

	}
	//=================================================================================================================
	//============================================== Hard =============================================================
	//=================================================================================================================
	private void firstWaveHard() {

		if (hud.getLevel() == 2) {
			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
		} else if (hud.getLevel() == 3) {
			handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
		} else if (hud.getLevel() == 4) {
			 handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),
			 r.nextInt(Game.HEIGHT) - 32, ID.FastEnemy));
		} else if (hud.getLevel() == 5) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			 handler.addObject(
			 new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) -
			 32, ID.SmartEnemy, handler));
		} else if (hud.getLevel() == 6) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
		} else if (hud.getLevel() == 7) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
		} else if (hud.getLevel() == 8) {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
			for (int i = 0; i < 10; i++) {
				handler.addObject(new RandomWaveOfBasicEnemy(0, r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
			}
		} else if (hud.getLevel() == 9) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
		} else if (hud.getLevel() == 10) {
			handler.clearEnemys();
			handler.addObject(new BigBoss(Game.WIDTH / 2 - 100, -100, ID.BigBoss, handler));
		} else if (hud.getLevel() == 15) {
			handler.clearEnemys();
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 16) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 17) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 18) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}

		} else if (hud.getLevel() == 19) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 20) {
			handler.addObject(new WaveEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.WaveEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
			wave1 = false;
			wave2 = true;
		}

	}

	public void secondWaveHard() {
		if (hud.getLevel() == 20) {
			handler.clearEnemys();
			handler.addObject(new RandomWaveOfBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32,
					ID.RandomWaveOfBasicEnemy));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));

		}
		if (hud.getLevel() == 22) {
			handler.clearEnemys();
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BasicEnemy));
		}
		if (hud.getLevel() == 24) {
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.FastEnemy));
		}
		if (hud.getLevel() == 26) {
			handler.addObject(
					new FastSmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.FastSmartEnemy, handler));
		} else if (hud.getLevel() == 27) {
			handler.clearEnemys();
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 28) {
			handler.clearEnemys();
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 29) {
			handler.clearEnemys();
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 30) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 31) {
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 32) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 33) {
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 34) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 35) {
			handler.addObject(new BigBasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.BigBasicEnemy));
			int multiple = 1;
			int gap = r.nextInt(20);
			for (int i = 0; i < 21; i++) {
				if (i != gap && i != gap + 1 && i != gap + 2 && i != gap + 3) {
					handler.addObject(new WaveOfBasicEnemy(0, 21 * multiple, ID.WaveBasicEnemy));
				}
				multiple++;
			}
		} else if (hud.getLevel() == 39) {
			handler.clearEnemys();
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
		} else if (hud.getLevel() == 40) {
			handler.addObject(
					new BigBoss2(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.SecondBigBoss, handler));
		} else if (hud.getLevel() == 45) {
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
			handler.addObject(new Health(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT) - 32, ID.Health));
		} else if (hud.getLevel() == 50) {
			JOptionPane.showMessageDialog(null, "You Won");
			Game.GameState = Game.GameState.End;
		}

	}

}
