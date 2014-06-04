package gameWar;


/**
 * @author Robin
 *
 */
public class Deplacement extends Action{

	/**
	 * @param robot
	 */
	public Deplacement(Robot r) {
		super(r);
	}

	/* (non-Javadoc)
	 * @see gameWar.Action#agit()
	 */
	@Override
	public boolean agit (Coordonnee direction) {
		Coordonnee newc = this.getRobot().getCoordonnee();
		for (int i=0; i<this.getRobot().getDeplacement(); i++) {
			newc = newc.ajouter(direction);
			if (!testDeplacementOK(direction)) {
				return false;
			}
		}
		deplacer(newc);
		return true;
	}

	/* (non-Javadoc)
	 * @see gameWar.Action#iaAgit(gameWar.Coordonnee)
	 */
	@Override
	public boolean iaAgit (Coordonnee direction) {
		Coordonnee newc = this.getRobot().getCoordonnee();
		for (int i=0; i<this.getRobot().getDeplacement(); i++) {
			newc = newc.ajouter(direction);
			if (!testDeplacementOK(direction)) {
				return false;
			}
		}
		deplacer(newc);
		return true;
	}

	/**
	 * @param robot
	 * @param nouvelleCoordonnee
	 * @return boolean
	 * 	retourne true si la case NouvelleCoordonne est en dehors du plateau
	 */
	private boolean testSortiePlateau(Robot r, Coordonnee newc) {
		return (!r.getVue().estOK(newc));
	}

	/**
	 * @param robot
	 * @param nouvelleCoordonnee
	 * @return boolean
	 * 	retourne true si la case NouvelleCoordonne est deja occuper par un autre robot
	 */
	private boolean testCollision(Robot r, Coordonnee newc) {
		return (!r.getVue().estLibre(newc) && !r.getVue().estBase(newc));
	}

	/**
	 * @param robot
	 * @param nouvelleCoordonnee
	 * @return boolean
	 * 	retourne true si la case NouvelleCoordonne contient un obstacle
	 */
	private boolean testObstacle(Robot r, Coordonnee newc) {
		return (r.getVue().estObstacle(newc));
	}

	/**
	 * @param robot
	 * @param nouvelleCoordonnee
	 * @return boolean
	 * 	retourne true si la case NouvelleCoordonne est une base
	 */
	private boolean testBase(Robot r, Coordonnee newc) {
		return (this.getRobot().getVue().plateau.estBase(newc.getX(), newc.getY())!=0
				&&this.getRobot().getVue().plateau.estBase(newc.getX(), newc.getY()) != this.getRobot().getEquipe());
	}

	/**
	 * @param direction
	 * @return boolean
	 * 	retourne true si le deplacement est possible, sinon il affiche un message d'erreur et refait jouer le joueur
	 */
	private boolean testDeplacementOK(Coordonnee direction) {
		Coordonnee newc = this.getRobot().getCoordonnee();
		for (int i=0; i<this.getRobot().getDeplacement(); i++) {
			newc = newc.ajouter(direction);
			if (testSortiePlateau(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					gameGraphic.WarPanel.t.setText("Déplacement impossible, vous ne pouvez pas quitter le\nchamp de bataille ! Choisissez une destination valide ou \nune autre action.");
					return false;
				}
			} else if (testObstacle(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					gameGraphic.WarPanel.t.setText("Déplacement impossible, Obstacle !!");
					return false;
				}
			} else if (testCollision(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					gameGraphic.WarPanel.t.setText("Déplacement impossible, le terrain est déjà occupé, le\nrisque de collision est important, choisissez une autre\ndestination ou une autre action.");
					return false;
				}
			} else if (testBase(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					gameGraphic.WarPanel.t.setText("Alerte ! Vous essayez de pénétrer une base ennemie ! Vous avez l’ordre de battre en retraite, choisissez une destination différente.");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param NouvelleCoordonnee
	 * 	Deplace le robot sur la case NouvelleCoordonnee
	 */
	private void deplacer(Coordonnee newc) {
		Plateau p = this.getRobot().getVue().plateau;
		if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.retirerRobot(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY(), this.getRobot());
			this.getRobot().setCoordonnee(newc);
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			if (p.estMine(newc.getX(), newc.getY())!=0) {
				gameGraphic.WarPanel.t.setText("Le "+this.getRobot().getType()+" numéro "+this.getRobot().getNum()+" de l'équipe "+this.getRobot().getEquipe()+" a marché sur une mine.");
				this.getRobot().subitDegats(2);
				p.retirerMine(newc.getX(), newc.getY());
			}
			if (this.getRobot().getEnergie() > 0)
				p.placerRobot(this.getRobot());
		}
	}
}

