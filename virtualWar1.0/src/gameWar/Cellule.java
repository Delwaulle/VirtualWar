package gameWar;

import java.util.ArrayList;

/**
 * @author Robin
 *
 */
public abstract class Cellule {

	protected int mine=0;
	protected int base=0;
	private boolean obstacle=false;
	ArrayList <Robot> r = new ArrayList <Robot>();
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "";
	}
	
	abstract void placerSur (Robot r);
	abstract boolean estDans (int num);
	abstract void videCase();
	abstract void retirerRobot(Robot r);
	abstract Robot getRobot(int equipe, int num);
	abstract Robot getContenu();
}
