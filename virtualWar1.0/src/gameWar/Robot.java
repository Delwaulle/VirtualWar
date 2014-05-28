package gameWar;


public abstract class Robot {

	private int energie;
	private int equipe;
	private int num;
	private Coordonnee coord;
	private Vue vue;
	private String typeJoueur;
	
	
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
	
	public boolean estSurBase() {
		return vue.estBase(this.coord);
	}
	
	public void setCoordonnee (Coordonnee coord) {
		this.coord=coord;
	}
	
	public Coordonnee getCoordonnee() {
		return this.coord;
	}
	
	public String getTypeJoueur() {
		return this.typeJoueur;
	}
	
	public Vue getVue () {
		return this.vue;
	}
	
	public void setVue (Vue vue) {
		this.vue=vue;
	}
	
	public int getEnergie() {
		return this.energie;
	}
	
	public void setEnergie (int energie) {
		this.energie=energie;
	}
	
	public int getEquipe() {
		return this.equipe;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void subitDegats(int degats) {
		System.out.println("Le "+this.getType()+" numéro "+this.getNum()+" de l'équipe "+this.getEquipe()+" subit "+degats+" point de dégats.");
		this.energie=this.energie-degats;
	}
	
	abstract public boolean peutTirer();
	abstract public int getCoutAction();
	abstract public int getCoutDep();
	abstract public int getDeplacement();
	abstract public int getDegatMine();
	abstract public int getDegatTir();
	abstract public int getPortee();
	abstract public String getType();
	abstract public boolean getDiagonal();
	abstract public String toString();

}
