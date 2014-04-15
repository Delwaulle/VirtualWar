package gameWar;

import java.util.List;

public class Tireur extends Robot{
	
	private int coutAction;
	private int coutDep;
	private int degatTir;
	private String type = "Tireur";
	
	public Tireur (Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
	}

	public boolean peutTirer() {
		return false;
	}
	
	public int getCoutAction() {
		return this.coutAction;
	}

	public int getCoutDep() {
		return this.coutDep;
	}

	public int getDegatMine() {
		return 0;
	}

	public int getDegatTir() {
		return this.degatTir;
	}

	public String getType() {
		return this.type;
	}

	public List<Coordonnee> getDeplacement() {
		return null;
	}
}
