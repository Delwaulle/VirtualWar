package gameWar;

public class Deplacement extends Action{
	
	public Deplacement(Robot r) {
		super(r);
	}
	
	public void agit () {
		Coordonnee direction = gameController.EntrerDirection.entrerDirection(this.getRobot().getDiagonal());
		Coordonnee newc = this.getRobot().getCoordonnee(); 
		for (int i=0; i<this.getRobot().getDeplacement(); i++)
			newc = newc.ajouter(direction); 
		if (testDeplacementOK(direction))
			deplacer(newc);
	}
	
	public void iaAgit (Coordonnee direction) {
		Coordonnee newc = this.getRobot().getCoordonnee(); 
		for (int i=0; i<this.getRobot().getDeplacement(); i++)
			newc = newc.ajouter(direction); 
		if (testDeplacementOK(direction))
			deplacer(newc);
	}
	
	private boolean testSortiePlateau(Robot r, Coordonnee newc) {
		return (!r.getVue().estOK(newc));
	}
	
	private boolean testCollision(Robot r, Coordonnee newc) {
		return (!r.getVue().estLibre(newc));
	}

	private boolean testObstacle(Robot r, Coordonnee newc) {
		return (r.getVue().estObstacle(newc));
	}
	
	private boolean testBase(Robot r, Coordonnee newc) {
		return (this.getRobot().getVue().plateau.estBase(newc.getX(), newc.getY())!=0 
				&&this.getRobot().getVue().plateau.estBase(newc.getX(), newc.getY()) != this.getRobot().getEquipe());
	}
	
	private boolean testDeplacementOK(Coordonnee direction) {
		Coordonnee newc = this.getRobot().getCoordonnee(); 
		for (int i=0; i<this.getRobot().getDeplacement(); i++) {
			newc = newc.ajouter(direction); 
			if (testSortiePlateau(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					System.out.println("Déplacement impossible, vous ne pouvez pas quitter le champ de bataille ! Choisissez une destination valide ou une autre action.");
					Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				}
			} else if (testObstacle(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					System.out.println("Déplacement impossible, Obstacle !!");
					Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				}
			} else if (testCollision(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					System.out.println("Déplacement impossible, le terrain est déjà occupé, le risque de collision est important, choisissez une autre destination ou une autre action.");
					Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				}
			} else if (testBase(this.getRobot(), newc)) {
				System.out.println("Alerte ! Vous essayez de pénétrer une base ennemie ! Vous avez l’ordre de battre en retraite, choisissez une destination différente.");
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				}
			} 
		}
		return true;
	}
	
	private void deplacer(Coordonnee newc) {
		Plateau p = this.getRobot().getVue().plateau;
		if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.retirerRobot(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY(), this.getRobot());
			this.getRobot().setCoordonnee(newc);
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			if (p.estMine(newc.getX(), newc.getY())!=0) {
				System.out.println("Le "+this.getRobot().getType()+" numéro "+this.getRobot().getNum()+" de l'équipe "+this.getRobot().getEquipe()+" à marcher sur une mine.");
				this.getRobot().subitDegats(2);
				p.retirerMine(newc.getX(), newc.getY());
			}	
			p.placerRobot(this.getRobot());
		}
	}
}

