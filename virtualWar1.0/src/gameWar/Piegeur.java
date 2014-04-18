package gameWar;

import java.util.List;

public class Piegeur extends Robot {

	private int coutAction=2;
	private int coutDep=2;
	private int degatMine=2;
	private String type="Piegeur";

	public Piegeur (Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		this.setEnergie(50);
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
	
	public String toString() {
		String e = "";
		if (this.getEnergie()<10)
			e=" "+this.getEnergie();
		else
			e=""+this.getEnergie();
		return    "+------------------------+\n"
				+ "|        PIEGEUR         |\n"
				+ "+------------------------+\n"
				+ "| Energie : "+e+"           |\n"
				+ "| Cout d'action : "+this.coutAction+"      |\n"
				+ "| Cout de deplacement : "+this.coutDep+"|\n"
				+ "| Degats : "+this.degatMine+"             |\n"
				+ "|                        |\n"
				+ "+------------------------+\n";
	}
}
