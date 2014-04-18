package gameWar;

/**
 * @author Robin
 *
 */
public abstract class Action {

	private final Robot robot;
	private final Coordonnee coordonnee;

	/**
	 * @param r
	 * @param c
	 */
	public Action (Robot r, Coordonnee c) {
		this.coordonnee=c;
		this.robot=r;
	}

	/**
	 * @return robot
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * @return la direction
	 */
	public Coordonnee getDirection() {
		return coordonnee;
	}

	abstract void agit();
}
