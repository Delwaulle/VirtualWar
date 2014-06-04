package gameWar;

import gameGraphic.ActionPanel;

public class Tir extends Action{

	public Tir(Robot r) {
		super(r);
	}

	@Override
	public boolean agit (Coordonnee direction) {
		if (testTirOK(direction)) {
			tirer(direction);
			return true;
		}
		return false;
	}

	@Override
	public boolean iaAgit (Coordonnee direction) {
		if (testTirOK(direction)) {
			tirer(direction);
			return true;
		}
		return false;
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
					gameGraphic.WarPanel.t.setText("Ajustez votre tir soldat, l’ennemi est en face ! ");
					gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
					return false;
				}
			} else if (testObstacle(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					gameGraphic.WarPanel.t.setText("Les obstacles arrêtent vos balles, choisissez une autre cible ou déplacez vous ! ");
					gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
					return false;
				}
			} else if (testBase(this.getRobot(), newc)) {
				if (this.getRobot().getTypeJoueur().equals("IARandom")) {
					IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
					return false;
				} else {
					gameGraphic.WarPanel.t.setText("Vos armes ne sont pas assez puissantes pour toucher les bases ! ");
					gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
					return false;
				}
			} else if (testCollision(this.getRobot(), newc)) {
				if (testTirAmi(this.getRobot(), newc)) {
					if (this.getRobot().getTypeJoueur().equals("IARandom")) {
						IARandom.jouer(this.getRobot().getVue().plateau, this.getRobot().getEquipe());
						return false;
					} else {
						gameGraphic.WarPanel.t.setText("Attention soldat, ne trahissez pas votre pays, visez l’ennemi !");
						gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
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
			gameGraphic.WarPanel.t.setText("Attention soldat, vous ne visez personne ! Ne décevez pas votre pays, ciblez un ennemi ou choisissez une autre action !");
			gameGraphic.WarPanel.p.add(new ActionPanel(this.getRobot().getEquipe()));
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
				gameGraphic.WarPanel.t.setText("Un robot a été touché !!");
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

