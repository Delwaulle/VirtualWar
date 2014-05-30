package gameWar;


/**
 * @author Robin
 *
 */
public class Char extends Robot{

	private final int coutAction=1;
	private final int coutDep=5;
	private final int degatTir=6;
	private final String type = "Char";
	private final int deplacement = 2;
	private final boolean diagonal = false;
	private final int portee = 10;
	public int energieMax=60;

	/**
	 * @param vue
	 * @param NumEquipe
	 * @param Num
	 * @param TypeJoueur
	 */
	public Char (Vue vue, int equipe, int num, String typeJoueur) {
		super(vue, equipe, num, typeJoueur);
		this.setEnergie(60);
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#peutTirer()
	 */
	@Override
	public boolean peutTirer() {
		return false;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getEnergieMax()
	 */
	@Override
	public int getEnergieMax() {
		return this.energieMax;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getCoutAction()
	 */
	@Override
	public int getCoutAction() {
		return this.coutAction;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getCoutDep()
	 */
	@Override
	public int getCoutDep() {
		return this.coutDep;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getDegatMine()
	 */
	@Override
	public int getDegatMine() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getDegatTir()
	 */
	@Override
	public int getDegatTir() {
		return this.degatTir;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getType()
	 */
	@Override
	public String getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getPortee()
	 */
	@Override
	public int getPortee() {
		return this.portee;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getDeplacement()
	 */
	@Override
	public int getDeplacement() {
		return this.deplacement;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#getDiagonal()
	 */
	@Override
	public boolean getDiagonal() {
		return this.diagonal;
	}

	/* (non-Javadoc)
	 * @see gameWar.Robot#toString()
	 */
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
