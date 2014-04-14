package gameWar;

import java.util.List;

public class Piegeur extends Robot {

	private int coutAction;
	private int coutDep;
	private int degatMine;
	private String type="Piegeur";

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
		return this.degatMine;
	}

	public int getDegatTir() {
		return 0;
	}

	public String getType() {
		return this.type;
	}

	public List<Coordonnee> getDeplacement() {
		return null;
	}
}
