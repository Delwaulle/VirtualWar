package gameWar;

public class Mine extends Action{

	public Mine(Robot r) {
		super(r);
	}

	@Override
	public void agit () {
		Coordonnee direction = gameController.EntrerDirection.entrerDirection(false);
		if (!this.getRobot().getVue().estOK(this.getRobot().getCoordonnee().ajouter(direction)) ) {
			System.out.println("Impossible, sortie plateau !!");
			Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
		} else if (this.getRobot().getVue().estObstacle(this.getRobot().getCoordonnee().ajouter(direction))) {
			System.out.println("Impossible, obstacle !!");
			Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
		} else if (this.getRobot().getVue().estMine(this.getRobot().getCoordonnee().ajouter(direction))) {
			System.out.println("Attention vous essayez de poser une mine sur une case déjà minée, veuillez choisir une autre case ou une autre action.");
			Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
		}else if (! this.getRobot().getVue().estLibre(this.getRobot().getCoordonnee().ajouter(direction))) {
			System.out.println("Impossible, Robot !!");
			Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
		} else {
			Plateau p = this.getRobot().getVue().plateau;
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(direction);
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
		}
	}

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

