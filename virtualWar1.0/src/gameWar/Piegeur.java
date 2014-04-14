package gameWar;

import java.util.List;

public class Piegeur extends Robot {

	private int coutAction;
	private int coutDep;
	private int degatMine;
	private String type;

	public boolean peutTirer() {
		return false;
	}
	
	public int getCoutAction() {
		return 0;
	}

	public int getCoutDep() {
		return 0;
	}

	public int getDegatMine() {
		return 0;
	}

	public int getDegatTire() {
		return 0;
	}

	public String getType() {
		return null;
	}

	public List<Coordonnee> getDeplacement() {
		return null;
	}
}
