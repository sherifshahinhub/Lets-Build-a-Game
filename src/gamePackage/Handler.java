package gamePackage;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	public void tick(){
		for (int i = 0; i < object.size(); i++) {
			final GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}

	public void render(final Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			final GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void clearEnemys(){
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			if (tempObject.getId() == ID.Player) {
				int playerX = (int) tempObject.getX();
				int playerY = (int) tempObject.getY();
				object.clear();
				addObject(new Player(playerX, playerY, ID.Player, this));
			}
		}
	}
	
	public void removeHealth() {
		for (int j = 0; j < object.size(); j++) {
			if (object.get(j).id == ID.Health) {
				object.remove(j);
			}
		}
	}
	public void clearAll() {
		if (object.size() != 0) {
			for (int i = 0; i < object.size(); i++) {
				object.remove(i);
			}
		}
	}
	public void addObject(final GameObject object) {
		this.object.add(object);
	}

	public void removeObject(final GameObject object) {
		this.object.remove(object);
	}

}
