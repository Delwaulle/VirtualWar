package gameWar;

import gameGraphic.ActionPanel;

/**
 * @author Robin
 *
 */
public class Mine extends Action{

	/**
	 * @param robot
	 */
	public Mine(Robot r) {
		super(r);
	}

	/* (non-Javadoc)
	 * @see gameWar.Action#agit()
	 */
	@Override
	public void agit (Coordonnee direction) {
		if (!this.getRobot().getVue().estOK(this.getRobot().getCoordonnee().ajouter(direction)) ) {
			System.out.println("Attention vous essayez de poser une mine en dehors du plateau, veuillez choisir une autre case ou une autre action. ");
			gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
		} else if (this.getRobot().getVue().estObstacle(this.getRobot().getCoordonnee().ajouter(direction))) {
			System.out.println("Attention soldat, vous ne pouvez poser de mines sur un obstacle, veuillez choisir une autre case ou une autre action. ");
			gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
		} else if (this.getRobot().getVue().estMine(this.getRobot().getCoordonnee().ajouter(direction))) {
			System.out.println("Attention vous essayez de poser une mine sur une case déjà minée, veuillez choisir une autre case ou une autre action.");
			gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
		}else if (! this.getRobot().getVue().estLibre(this.getRobot().getCoordonnee().ajouter(direction))) {
			System.out.println(" Attention, les mines ne peuvent être posée qu’au sol ! Vous ne pouvez pas assommer un robot avec, veuillez choisir une autre case ou une autre action.");
			gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
		} else {
			Plateau p = this.getRobot().getVue().plateau;
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(direction);
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
		}
	}

	/* (non-Javadoc)
	 * @see gameWar.Action#iaAgit(gameWar.Coordonnee)
	 */
	@Override
	public void iaAgit (Coordonnee direction) {
		if (this.getRobot().getVue().estOK(this.getRobot().getCoordonnee().ajouter(direction))
				&& this.getRobot().getVue().estObstacle(this.getRobot().getCoordonnee().ajouter(direction))
				&& this.getRobot().getVue().estMine(this.getRobot().getCoordonnee().ajouter(direction))
				&& !this.getRobot().getVue().estLibre(this.getRobot().getCoordonnee().ajouter(direction)))
			IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
		else {
			Plateau p = this.getRobot().getVue().plateau;
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(direction);
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
		}
	}
}

