package gameWar;

import java.util.List;

public class Tireur extends Robot{
	
	private int coutAction=2;
	private int coutDep=1;
	private int degatTir=3;
	private String type = "Tireur";
	
	public Tireur (Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		this.setEnergie(40);
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
	
	public String toString() {
		return    "+------------------------+\n"
				+ "|        TIREUR          |\n"
				+ "+------------------------+\n"
				+ "| Energie : "+this.getEnergie()+"           |\n"
				+ "| Cout d'action : "+this.coutAction+"      |\n"
				+ "| Cout de deplacement : "+this.coutDep+"|\n"
				+ "| Degats : "+this.degatTir+"             |\n"
				+ "|                        |\n"
				+ "+------------------------+\n";
	}
}
