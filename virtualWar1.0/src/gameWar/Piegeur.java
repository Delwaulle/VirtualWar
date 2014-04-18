package gameWar;

import java.util.List;

/**
 * @author Loic
 *
 */
public class Piegeur extends Robot {

	private final int coutAction=2;
	private final int coutDep=2;
	private final int degatMine=2;
	private final String type="Piegeur";

	/**
	 * @param vue
	 * @param x
	 * @param y
	 * @param equipe
	 */
	public Piegeur (Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		this.setEnergie(50);
	}

	@Override
	public boolean peutTirer() {
		return false;
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
		return this.degatMine;
	}

	@Override
	public int getDegatTir() {
		return 0;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public List<Coordonnee> getDeplacement() {
		return null;
	}

	/**
	 * description affichage caractéristiques du robot
	 */
	@Override
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
