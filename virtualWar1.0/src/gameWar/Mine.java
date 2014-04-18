package gameWar;

/**
 * @author Loic
 *
 */
public class Mine extends Action{

	/**
	 * @param r
	 * @param c
	 */
	public Mine(Robot r, Coordonnee c) {
		super(r, c);
	}

	/**
	 * 
	 */
	@Override
	public void agit () {
		Plateau p = this.getRobot().getVue().plateau;
		Coordonnee newc = this.getRobot().getCoordonnee().ajouter(this.getDirection());
		if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
		}
	}
}

