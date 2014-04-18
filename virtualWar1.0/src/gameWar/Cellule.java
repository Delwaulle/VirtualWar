package gameWar;

/**
 * @author Robin
 *
 */
public abstract class Cellule {

	protected int mine=0;
	protected int base=0;
	private boolean obstacle=false;
	Robot r;
	Coordonnee coord;

	/**
	 * 
	 */
	public Cellule() {

	}

	/**
	 * @return int
	 */
	public int estMine(){
		return this.mine;
	}

	/**
	 * @param equipe
	 */
	public void placerMine (int equipe) {
		this.mine=equipe;
	}

	/**
	 * @return int
	 */
	public int estBase () {
		return this.base;
	}

	/**
	 * @param equipe
	 */
	public void placerBase(int equipe) {
		this.base=equipe;
	}

	/**
	 * @return coordonnee
	 */
	public Coordonnee getCoordonnee() {
		return this.coord;
	}

	/**
	 * @return boolean
	 */
	public boolean estObstacle() {
		return this.obstacle;
	}

	/**
	 * 
	 */
	public void placerObstacle() {
		this.obstacle=true;
	}

	/**
	 * @return robot
	 */
	public Robot getContenu() {
		return this.r;
	}

	/**
	 * @return une chaine vide
	 */
	@Override
	public String toString() {
		return "";
	}

	abstract void placerSur (Robot r);
	abstract void videCase();
}
