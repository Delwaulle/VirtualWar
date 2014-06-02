package gameWar;

/**
 * @author Robin
 *
 */
public abstract class Action {

	private final Robot robot;
	private Coordonnee coordonnee;


	/**
	 * @param Robot
	 */
	public Action (Robot r) {
		this.robot=r;
	}

	/**
	 * @param Robot
	 * @param Coordonnee
	 */
	public Action (Robot r, Coordonnee c) {
		this.coordonnee=c;
		this.robot=r;
	}

	/**
	 * @return Robot
	 *
	 *	Retourne le robot qui effectue l'action
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * @return Coordonnee
	 * 
	 * 	Retourne la direction dans laquelle s'effectue l'action
	 */
	public Coordonnee getDirection() {
		return coordonnee;
	}

	/**
	 * 	Effectue l'action pour un Joueur
	 */
	public abstract void agit(Coordonnee direction);

	/**
	 * @param direction
	 * 
	 * Effectue l'action pour une IA random
	 */
	abstract void iaAgit(Coordonnee direction);
}
