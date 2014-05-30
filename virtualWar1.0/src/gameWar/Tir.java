package gameWar;

public class Tir extends Action{

	public Tir(Robot r) {
		super(r);
	}

	@Override
	public void agit () {
		Coordonnee direction = gameController.EntrerDirection.entrerDirection(false);
		if (testTirOK(direction))
			tirer(direction);
	}

	@Override
	public void iaAgit (Coordonnee direction) {
		if (testTirOK(direction))
			tirer(direction);
	}

	public boolean testTirOK(Coordonnee direction) {
		Coordonnee newc = this.getRobot().getCoordonnee();
		for (int i=0; i<this.getRobot().getPortee(); i++) {
			newc=newc.ajouter(direction);
			if (testSortiePlateau(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					System.out.println("Ajustez votre tir soldat, l’ennemi est en face ! ");
					Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				}
			} else if (testObstacle(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					System.out.println("Les obstacles arrêtent vos balles, choisissez une autre cible ou déplacez vous ! ");
					Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				}
			} else if (testBase(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					System.out.println("Vos armes ne sont pas assez puissantes pour toucher les bases ! ");
					Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				}
			} else if (testCollision(this.getRobot(), newc)) {
				if (testTirAmi(this.getRobot(), newc)) {
					if (this.getRobot().getTypeJoueur().equals("IARandom")) {
						IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
						return false;
					} else {
						System.out.println("Attention soldat, ne trahissez pas votre pays, visez l’ennemi !");
						Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
						return false;
					}
				}
				return true;
			}
		}
		if (this.getRobot().getTypeJoueur().equals("IARandom")) {
			IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
			return false;
		} else {
			System.out.println("Attention soldat, vous ne visez personne ! Ne décevez pas votre pays, ciblez un ennemi ou choisissez une autre action !");
			Joueur.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
			return false;
		}
	}

	private void tirer(Coordonnee direction) {
		Plateau p = this.getRobot().getVue().plateau;
		Coordonnee newc = this.getRobot().getCoordonnee();
		boolean tir = false;
		for (int i=0; i<this.getRobot().getPortee() && !tir; i++) {
			newc=newc.ajouter(direction);
			if(this.getRobot().getVue().estOK(newc) && testCollision(this.getRobot(), newc)) {
				tir=true;
				System.out.println("Un robot a été touché !!");
				p.getContenu(newc.getX(), newc.getY()).subitDegats(this.getRobot().getDegatTir());
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
				if (p.getContenu(newc.getX(), newc.getY()).getEnergie()<=0) {
					System.out.println("Le robot est mort !!");
					p.retirerRobot(newc.getX(), newc.getY(), p.getContenu(newc.getX(),  newc.getY()));
				}
			}
		}
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
		return (this.getRobot().getVue().plateau.estBase(newc.getX(), newc.getY())!=0 );
	}

	private boolean testTirAmi(Robot r, Coordonnee newc) {
		return this.getRobot().getEquipe()==this.getRobot().getVue().plateau.getContenu(newc.getX(), newc.getY()).getEquipe();
	}
}

