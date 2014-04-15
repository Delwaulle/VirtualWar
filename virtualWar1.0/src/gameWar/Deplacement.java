package gameWar;

public class Deplacement extends Action{
	
	public Deplacement(Robot r, int i) {
		super(r, i);
	}
	
	public void agit () {
		Plateau p = this.getRobot().getVue().plateau;
		if (i==0) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.HAUT); 
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.setLibre(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY());
			this.getRobot().setCoordonnee(newc);
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			p.placerRobot(this.getRobot());
			}
		}
		else if (i ==1) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.DROITE); 
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.setLibre(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY());
			this.getRobot().setCoordonnee(newc);
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			p.placerRobot(this.getRobot());
			}
		}
		else if (i ==2) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.BAS); 
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.setLibre(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY());
			this.getRobot().setCoordonnee(newc);
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			p.placerRobot(this.getRobot());
			}
		}
		else if (i ==3) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.GAUCHE); 
				if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.setLibre(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY());
				this.getRobot().setCoordonnee(newc);
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
				p.placerRobot(this.getRobot());
			}
		} 
	}
}

