package gameWar;


/**
 * @author Robin
 *
 */
public abstract class Robot {

	private int energie;
	private final int equipe;
	private final int num;
	private Coordonnee coord;
	private Vue vue;
	private final String typeJoueur;



	/**
	 * @param vue
	 * @param equipe
	 * @param num
	 * @param typeJoueur
	 */
	public Robot (Vue vue, int equipe, int num, String typeJoueur) {
		this.vue=vue;
		if (equipe == 1)
			this.coord= new Coordonnee(0, 0);
		else
			this.coord= new Coordonnee(Plateau.hauteur-1, Plateau.largeur-1);
		this.equipe=equipe;
		this.num=num;
		this.typeJoueur=typeJoueur;
	}

	/**
	 * @return boolean
	 * 	retourne true si le robot est sur une base
	 */
	public boolean estSurBase() {
		return vue.estBase(this.coord);
	}

	/**
	 * @param coord
	 * Modifie les coordonnees du robot
	 */
	public void setCoordonnee (Coordonnee coord) {
		this.coord=coord;
	}

	/**
	 * @return coordonnee
	 * Retourne les coordonnees du robot
	 */
	public Coordonnee getCoordonnee() {
		return this.coord;
	}

	/**
	 * @return String
	 * retourne le Type de joueur
	 */
	public String getTypeJoueur() {
		return this.typeJoueur;
	}

	/**
	 * @return Vue
	 * retourne la vue du robot
	 */
	public Vue getVue () {
		return this.vue;
	}

	/**
	 * @param vue
	 * Modifie la vue du robot
	 */
	public void setVue (Vue vue) {
		this.vue=vue;
	}

	/**
	 * @return int
	 * retourne l'energie du robot
	 */
	public int getEnergie() {
		return this.energie;
	}

	/**
	 * @param energie
	 * modifie l'energie du robot
	 */
	public void setEnergie (int energie) {
		this.energie=energie;
	}

	/**
	 * @return int
	 * retourne le numero d'equipe du robot
	 */
	public int getEquipe() {
		return this.equipe;
	}

	/**
	 * @return int
	 * retourne le numero du robot
	 */
	public int getNum() {
		return this.num;
	}

	/**
	 * @param degats
	 * inflige des degats au robot
	 */
	public void subitDegats(int degats) {
		System.out.println("Le "+this.getType()+" numéro "+this.getNum()+" de l'équipe "+this.getEquipe()+" subit "+degats+" point de dégats.");
		this.energie=this.energie-degats;
	}

	/**
	 * @return boolean
	 * retourne true si le robot peut tirer
	 */
	abstract public boolean peutTirer();

	/**
	 * @return int
	 * retourne l'energie max du robot
	 */
	abstract public int getEnergieMax();

	/**
	 * @return int
	 * retourne le cout d'une action du robot
	 */
	abstract public int getCoutAction();

	/**
	 * @return int
	 * retourne le cout d'un deplacement du robot
	 */
	abstract public int getCoutDep();

	/**
	 * @return int
	 * retourne le nombre de case de deplacement que peut avoir le robot
	 */
	abstract public int getDeplacement();
	abstract public int getDegatMine();
	abstract public int getDegatTir();
	abstract public int getPortee();
	abstract public String getType();
	abstract public boolean getDiagonal();
	@Override
	abstract public String toString();

}
