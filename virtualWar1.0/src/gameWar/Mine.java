package gameWar;

public class Mine extends Action{
	
	public Mine(Robot r, Coordonnee c) {
		super(r, c);
	}
	
	public void agit () {
		Plateau p = this.getRobot().getVue().plateau;
		Coordonnee newc = this.getRobot().getCoordonnee().ajouter(this.getDirection()); 
		if(this.getRobot().getVue().estOK(newc) && this.getRobot().getVue().estLibre(newc)) {
			p.placerMine(newc.getX(), newc.getY(), this.getRobot().getEquipe());			
			this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
		}
	}		
}

