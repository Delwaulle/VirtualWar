package gameWar;


public class Piegeur extends Robot {

	private int coutAction=2;
	private int coutDep=2;
	private int degatMine=2;
	private String type="Piegeur";
	private int deplacement = 1;
	private boolean diagonal=true;
	private int portee = 1;

	public Piegeur (Vue vue, int equipe, int num, String typeJoueur) {
		super(vue, equipe, num, typeJoueur);
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

	public int getDeplacement() {
		return this.deplacement;
	}
	
	public int getPortee() {
		return this.portee;
	}
	
	public boolean getDiagonal() {
		return this.diagonal;
	}
	
	public String toString() {
		String e = "";
		String c = "";
		if (this.getEnergie()<10)
			e=" "+this.getEnergie();
		else
			e=""+this.getEnergie();
		if (this.getCoutDep()<10)
			c=" "+this.getCoutDep();
		else
			c=""+this.getCoutDep();
		return    "+-------------------------+\n"
				+ "|        PIEGEUR          |\n"
				+ "+-------------------------+\n"
				+ "| Equipe num : "+this.getEquipe()+"          |\n"
				+ "| Robot num : "+this.getNum()+"           |\n"
				+ "+-------------------------+\n"
				+ "| Energie : "+e+"            |\n"
				+ "| Déplacement :"+this.deplacement+"          |\n"
				+ "| Cout d'action : "+this.coutAction+"       |\n"
				+ "| Cout de deplacement : "+c+"|\n"
				+ "| Degats : "+this.degatMine+"              |\n"
				+ "|                         |\n"
				+ "+-------------------------+\n";
	}
}
