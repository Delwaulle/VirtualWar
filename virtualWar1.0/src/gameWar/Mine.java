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
	public boolean agit (Coordonnee direction) {
		if (!this.getRobot().getVue().estOK(this.getRobot().getCoordonnee().ajouter(direction)) ) {
			gameGraphic.WarPanel.t.setText("Attention vous essayez de poser une mine en dehors du plateau, veuillez choisir une autre case ou une autre action. ");
			return false;
		} else if (this.getRobot().getVue().estObstacle(this.getRobot().getCoordonnee().ajouter(direction))) {
			gameGraphic.WarPanel.t.setText("Attention soldat, vous ne pouvez poser de mines sur un obstacle, veuillez choisir une autre case ou une autre action. ");
			return false;
		} else if (this.getRobot().getVue().estMine(this.getRobot().getCoordonnee().ajouter(direction))) {
			gameGraphic.WarPanel.t.setText("Attention vous essayez de poser une mine sur une case déjà minée, veuillez choisir une autre case ou une autre action.");
			return false;
		}else if (! this.getRobot().getVue().estLibre(this.getRobot().getCoordonnee().ajouter(direction))) {
			gameGraphic.WarPanel.t.setText(" Attention, les mines ne peuvent être posée qu’au sol ! Vous ne pouvez pas assommer un robot avec, veuillez choisir une autre case ou une autre action.");
			return false;
		} else {
			Plateau p = this.getRobot().getVue().plateau;
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(direction);
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see gameWar.Action#iaAgit(gameWar.Coordonnee)
	 */
	@Override
	public boolean iaAgit (Coordonnee direction) {
		if (this.getRobot().getVue().estOK(this.getRobot().getCoordonnee().ajouter(direction))
				&& this.getRobot().getVue().estObstacle(this.getRobot().getCoordonnee().ajouter(direction))
				&& this.getRobot().getVue().estMine(this.getRobot().getCoordonnee().ajouter(direction))
				&& !this.getRobot().getVue().estLibre(this.getRobot().getCoordonnee().ajouter(direction)))
			return false;
		else {
			Plateau p = this.getRobot().getVue().plateau;
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(direction);
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
				return true;
			}
		}
		return false;
	}
}

