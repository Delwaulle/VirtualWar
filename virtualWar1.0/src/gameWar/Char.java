package gameWar;


public class Char extends Robot{
	
	private int coutAction=1;
	private int coutDep=10;
	private int degatTir=6;
	private String type = "Char";
	private int deplacement = 2;
	private boolean diagonal = false;
	private int portee = 10;
	
	public Char (Vue vue, int equipe, int num, String typeJoueur) {
		super(vue, equipe, num, typeJoueur);
		this.setEnergie(60);
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
	
	public int getPortee() {
		return this.portee;
	}

	public int getDeplacement() {
		return this.deplacement;
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
				+ "|         CHAR            |\n"
				+ "+-------------------------+\n"
				+ "| Equipe num : "+this.getEquipe()+"          |\n"
				+ "| Robot num : "+this.getNum()+"           |\n"
				+ "+-------------------------+\n"
				+ "| Energie : "+e+"            |\n"
				+ "| Déplacement :"+this.deplacement+"          |\n"
				+ "| Cout d'action : "+this.coutAction+"       |\n"
				+ "| Cout de deplacement : "+c+"|\n"
				+ "| Degats : "+this.degatTir+"              |\n"
				+ "|                         |\n"
				+ "+-------------------------+\n";
	}
}
