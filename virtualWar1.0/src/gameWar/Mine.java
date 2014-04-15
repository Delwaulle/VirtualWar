package gameWar;

public class Mine extends Action{
	
	public Mine(Robot r, int i) {
		super(r, i);
	}
	
	public void agit () {
		Plateau p = this.getRobot().getVue().plateau;
		if (i==0) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.HAUT); 
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());			
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
		}
		else if (i ==1) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.DROITE); 
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());			
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
		}
		else if (i ==2) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.BAS); 
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());			
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
		}
		else if (i ==3) {
			Coordonnee newc = this.getRobot().getCoordonnee().ajouter(Constante.GAUCHE); 
			if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
				p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());			
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
			}
		} 
	}
}

