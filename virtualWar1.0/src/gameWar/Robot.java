package gameWar;

import java.util.List;

public abstract class Robot {

	private int energie;
	private int equipe;
	private Coordonnee coord;
	private Vue vue;
	
	public Robot() {
		
	}
	
	public Robot (Vue vue, int x, int y, int equipe) {
		this.vue=vue;
		this.coord= new Coordonnee(x, y);
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
		return 0;
	}
	
	public void setEnergie (int energie) {
		
	}
	
	public int getEquipe() {
		return 0;
	}
	
	public void subitTir() {
		
	}
	
	public void subitMine() {
		
	}
	
	abstract public boolean peutTirer();
	abstract public int getCoutAction();
	abstract public int getCoutDep();
	abstract public int getDegatMine();
	abstract public int getDegatTire();
	abstract public String getType();
	abstract public List<Coordonnee> getDeplacement();

}
