package gameWar;

/**
 * @author Robin
 *
 */
public class Coordonnee {

	private final int x;
	private final int y;

	/**
	 * @param x
	 * @param y
	 */
	public Coordonnee (int x, int y){
		this.x=x;
		this.y=y;
	}

	/**
	 * @return int x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return int y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param coord
	 * @return coord
	 */
	public Coordonnee ajouter (Coordonnee coord) {
		return new Coordonnee(this.x+coord.getX(), this.y+coord.getY());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "";
	}
}
