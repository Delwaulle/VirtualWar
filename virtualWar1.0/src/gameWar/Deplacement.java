package gameWar;

/**
 * @author Loic
 *
 */
public class Deplacement extends Action{

	/**
	 * @param r
	 * @param c
	 */
	public Deplacement(Robot r, Coordonnee c) {
		super(r, c);
	}

	/**
	 * description G�re les d�placements d'un robot et v�rifie les collisions avec les mines.
	 */
	@Override
	public void agit () {
		Plateau p = this.getRobot().getVue().plateau; Coordonnee newc = this.getRobot().getCoordonnee().ajouter(this.getDirection());
		if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.setLibre(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY());
			this.getRobot().setCoordonnee(newc);
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			if (p.estMine(newc.getX(), newc.getY())!=0) {
				System.out.println("Vous avez touch� une mine !!");
				this.getRobot().subitDegats(2);
				p.retirerMine(newc.getX(), newc.getY());
			}
			p.placerRobot(this.getRobot());
		}
	}
}

