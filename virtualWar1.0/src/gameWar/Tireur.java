package gameWar;


public class Tireur extends Robot{

	private final int coutAction=2;
	private final int coutDep=1;
	private final int degatTir=3;
	private final String type = "Tireur";
	private final int deplacement = 1;
	private final boolean diagonal=true;
	private final int portee = 1;
	private final int energieMax=40;

	public Tireur (Vue vue, int equipe, int num, String typeJoueur) {
		super(vue, equipe, num, typeJoueur);
		this.setEnergie(40);
	}

	@Override
	public boolean peutTirer() {
		return false;
	}

	@Override
	public int getEnergieMax() {
		return this.energieMax;
	}

	@Override
	public int getCoutAction() {
		return this.coutAction;
	}

	@Override
	public int getCoutDep() {
		return this.coutDep;
	}

	@Override
	public int getDegatMine() {
		return 0;
	}

	@Override
	public int getDegatTir() {
		return this.degatTir;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public int getDeplacement() {
		return this.deplacement;
	}

	@Override
	public boolean getDiagonal() {
		return this.diagonal;
	}

	@Override
	public int getPortee() {
		return this.portee;
	}

	@Override
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
		+ "|        TIREUR           |\n"
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
