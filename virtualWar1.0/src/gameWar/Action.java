package gameWar;

public abstract class Action {
	
	private Robot robot;
	private Coordonnee coordonnee;

	public Action (Robot r, Coordonnee c) {
		this.coordonnee=c;
		this.robot=r;
	}
	
	public Robot getRobot() {
		return robot;
	}
	
	public Coordonnee getDirection() {
		return coordonnee;
	}
	
	abstract void agit();
}
