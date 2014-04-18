package gameWar;

import java.util.List;

/**
 * @author Robin
 *
 */
public abstract class Robot {

	private int energie;
	private int equipe;
	private Coordonnee coord;
	private Vue vue;
	
	
	/**
	 * @param vue
	 * @param x
	 * @param y
	 * @param equipe
	 */
	public Robot (Vue vue, int x, int y, int equipe) {
		this.vue=vue;
		if (equipe == 1)
			this.coord= new Coordonnee(0, 0);
		else
			this.coord= new Coordonnee(Plateau.HAUTEUR-1, Plateau.LARGEUR-1);
		this.equipe=equipe;
	}
	
	/**
	 * @return true si un robot est dans une base
	 */
	public boolean estSurBase() {
		return vue.estBase(this.coord);
	}
	
	/**
	 * @param coord
	 */
	public void setCoordonnee (Coordonnee coord) {
		this.coord=coord;
	}
	
	/**
	 * @return les coordonnées d'un robot
	 */
	public Coordonnee getCoordonnee() {
		return this.coord;
	}
	
	/**
	 * @return la vue du robot
	 */
	public Vue getVue () {
		return this.vue;
	}
	
	/**
	 * @param vue
	 */
	public void setVue (Vue vue) {
		this.vue=vue;
	}
	
	/**
	 * @return l'énergie du robot
	 */
	public int getEnergie() {
		return this.energie;
	}
	
	/**
	 * @param energie
	 */
	public void setEnergie (int energie) {
		this.energie=energie;
	}
	
	/**
	 * @return l'équipe à laquelle le robot appartient
	 */
	public int getEquipe() {
		return this.equipe;
	}
	
	/**
	 * @param degats
	 */
	public void subitDegats(int degats) {
		this.energie=this.energie-degats;
	}
	
	abstract public boolean peutTirer();
	abstract public int getCoutAction();
	abstract public int getCoutDep();
	abstract public int getDegatMine();
	abstract public int getDegatTir();
	abstract public String getType();
	abstract public List<Coordonnee> getDeplacement();
	abstract public String toString();

}
