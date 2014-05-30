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
	 * 
	 * 	Retourne le numero de l'equipe qui à poser la mine ou retourne 0 s'il n'y a pas de mine
	 */
	public int estMine(){
		return this.mine;
	}

	/**
	 * @param NumEquipe
	 * 
	 * 	Place une mine sur la cellule
	 */
	public void placerMine (int equipe) {
		this.mine=equipe;
	}

	/**
	 * @return int
	 * 
	 * 	retourne le numero d'equipe de la base ou retourne 0 s'il n'y a pas de base
	 */
	public int estBase () {
		return this.base;
	}

	/**
	 * @param NumEquipe
	 * 
	 * 	Place une base sur la cellule
	 */
	public void placerBase(int equipe) {
		this.base=equipe;
	}

	/**
	 * @return coordonnee
	 * 
	 * 	Retourne les coordonnees de la cellule
	 */
	public Coordonnee getCoordonnee() {
		return this.coord;
	}

	/**
	 * @return boolean
	 * 
	 * 	Retourne true s'il y a un obstacle sur la cellule
	 */
	public boolean estObstacle() {
		return this.obstacle;
	}

	/**
	 * 	Place un obstacle sur la cellule
	 */
	public void placerObstacle() {
		this.obstacle=true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "";
	}

	/**
	 * @param Robot
	 * 
	 *  place un Robot dans la Cellule
	 */
	abstract void placerSur (Robot r);

	/**
	 * @param Num
	 * @return boolean
	 * 	retourne true si le robot dont le numero est passe en parametre est dans la Base
	 */
	abstract boolean estDans (int num);

	/**
	 *	Vide la case
	 */
	abstract void videCase();

	/**
	 * @param Robot
	 * 	Retir le robot passé en parametre de la cellule
	 */
	abstract void retirerRobot(Robot r);

	/**
	 * @param NumEquipe
	 * @param Num
	 * @return Robot
	 * 
	 * 	Retourne le robot qui correspond au numero de robot et au numero d'équipe passé en parametre s'il est dans la cellule, sinon retourne null
	 */
	abstract Robot getRobot(int equipe, int num);

	/**
	 * @return Robot
	 * 	Retourne le robot s'il y en a un dans la cellule, sinon retourne null
	 */
	abstract Robot getContenu();
}
