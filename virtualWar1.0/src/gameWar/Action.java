package gameWar;

public abstract class Action {

	public Action (Robot r, Coordonnee direction) {
		
	}
	
	public Robot getRobot() {
		return new Tireur();
	}
	
	public Coordonnee getDirection() {
		return new Coordonnee(0,0);
	}
	
	public Coordonnee getObjectif() {
		return new Coordonnee(0,0);
	}
	
	abstract void agit();

}
