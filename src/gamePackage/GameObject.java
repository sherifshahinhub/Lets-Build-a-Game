package gamePackage;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected  float x;
	protected  float y;
	protected ID id;
	protected float velX, velY;

	public GameObject (final float x, final float y, final ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();   //tick = «··ÕŸ…
	public abstract void render(Graphics g); // render = «·«⁄œ«œ
	public abstract Rectangle getBounds();

	/**
	 * @return the x
	 */
	public  float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(final int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public  float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(final int y) {
		this.y = y;
	}

	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final ID id) {
		this.id = id;
	}

	/**
	 * @return the velX
	 */
	public float getVelX() {
		return velX;
	}

	/**
	 * @param velX the velX to set
	 */
	public void setVelX(final int velX) {
		this.velX = velX;
	}

	/**
	 * @return the velY
	 */
	public float getVelY() {
		return velY;
	}

	/**
	 * @param velY the velY to set
	 */
	public void setVelY(final int velY) {
		this.velY = velY;
	}


}
