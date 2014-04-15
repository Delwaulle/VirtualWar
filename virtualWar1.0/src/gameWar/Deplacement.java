package gameWar;

public class Deplacement extends Action{
	
	public Deplacement(Robot r, Coordonnee c) {
		super(r, c);
	}
	
	public void agit () {
		Plateau p = this.getRobot().getVue().plateau;
		Coordonnee newc = this.getRobot().getCoordonnee().ajouter(this.getDirection()); 
		if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.setLibre(this.getRobot().getCoordonnee().getX(), this.getRobot().getCoordonnee().getY());
			this.getRobot().setCoordonnee(newc);
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutDep());
			if (p.estMine(newc.getX(), newc.getY())!=0) {
				this.getRobot().subitDegats(2);
				p.retirerMine(newc.getX(), newc.getY());
			}	
		p.placerRobot(this.getRobot());
		}
	}
}

