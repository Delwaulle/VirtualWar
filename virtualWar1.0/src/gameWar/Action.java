package gameWar;

/**
 * @author Robin
 *
 */
public abstract class Action {
	
	private Robot robot;
	private Coordonnee coordonnee;

	/**
	 * @param robot
	 * @param coordonnee
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
