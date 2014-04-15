package gameWar;

import java.util.List;

public abstract class Robot {

	private int energie;
	private int equipe;
	private Coordonnee coord;
	private Vue vue;
	
	
	public Robot (Vue vue, int x, int y, int equipe) {
		this.vue=vue;
		if (equipe == 1)
			this.coord= new Coordonnee(0, 0);
		else
			this.coord= new Coordonnee(Plateau.HAUTEUR-1, Plateau.LARGEUR-1);
		this.equipe=equipe;
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
	
	public void subitTir() {
		
	}
	
	public void subitMine() {
		
	}
	
	abstract public boolean peutTirer();
	abstract public int getCoutAction();
	abstract public int getCoutDep();
	abstract public int getDegatMine();
	abstract public int getDegatTir();
	abstract public String getType();
	abstract public List<Coordonnee> getDeplacement();

}
