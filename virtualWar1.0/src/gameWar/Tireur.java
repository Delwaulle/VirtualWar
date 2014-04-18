package gameWar;

import java.util.List;

/**
 * @author Robin
 *
 */
public class Tireur extends Robot{

	private final int coutAction=2;
	private final int coutDep=1;
	private final int degatTir=3;
	private final String type = "Tireur";

	/**
	 * @param vue
	 * @param x
	 * @param y
	 * @param equipe
	 */
	public Tireur (Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		this.setEnergie(40);
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
	public List<Coordonnee> getDeplacement() {
		return null;
	}

	@Override
	public String toString() {
		String e = "";
		if (this.getEnergie()<10)
			e=" "+this.getEnergie();
		else
			e=""+this.getEnergie();
		return    "+------------------------+\n"
		+ "|        TIREUR          |\n"
		+ "+------------------------+\n"
		+ "| Energie : "+e+"           |\n"
		+ "| Cout d'action : "+this.coutAction+"      |\n"
		+ "| Cout de deplacement : "+this.coutDep+"|\n"
		+ "| Degats : "+this.degatTir+"             |\n"
		+ "|                        |\n"
		+ "+------------------------+\n";
	}
}
